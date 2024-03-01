package com.se.movie.simple.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Mono;

@Component
@RefreshScope
public class AuthFilters implements GatewayFilter {
	@Autowired
	private RouterValidator routerValidator;
	
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		ServerHttpRequest request = exchange.getRequest();
		if (!routerValidator.isSecured.test(request)) {
			if (this.isAuthMissing(request))
				return this.onError(exchange, "Authorization header is missing in request", HttpStatus.UNAUTHORIZED);

			final String token = this.getAuthHeader(request);

			if (!jwtUtil.isInvalid(token))
				return this.onError(exchange, "Authorization header is invalid", HttpStatus.UNAUTHORIZED);

			try {
				this.populateRequestWithHeaders(exchange, token);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return chain.filter(exchange);
	}

	/* PRIVATE */
	private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
		ServerHttpResponse response = exchange.getResponse();
		response.setStatusCode(httpStatus);
		return response.setComplete();
	}

	private String getAuthHeader(ServerHttpRequest request) {
		return request.getHeaders().getOrEmpty("Authorization").get(0);
	}

	private boolean isAuthMissing(ServerHttpRequest request) {
		return !request.getHeaders().containsKey("Authorization");
	}

	private void populateRequestWithHeaders(ServerWebExchange exchange, String token) throws JsonProcessingException {
		Claims claims = jwtUtil.getAllClaimsFromToken(token);
		
		String userId = claims.getSubject();
		exchange.getRequest().mutate()
				.header("$userId", userId)
				.build();
	}
}