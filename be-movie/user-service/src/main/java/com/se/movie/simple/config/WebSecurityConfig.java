package com.se.movie.simple.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@SuppressWarnings("deprecation")
	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new UserAuthenticationSuccessHandler();
	}

	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new UserAuthenticationFailureHandler();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.addFilterBefore(
				new HeaderUsernamePasswordAuthenticationFilter(),
				UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.requestMatchers("/index.html").permitAll()
				.requestMatchers("/swagger-ui.html").hasRole("ADMIN")
				.anyRequest()
				.authenticated();
		http.csrf().disable()
				.authorizeHttpRequests().requestMatchers("/login", "/regist").permitAll();

		http.addFilterBefore( authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}