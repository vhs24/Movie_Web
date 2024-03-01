package com.se.movie.simple.controller.intenal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.se.movie.simple.domain.common.GeneratorCommonUtil;
import com.se.movie.simple.domain.common.ObjectMapperCommonUtil;
import com.se.movie.simple.domain.entity.User;
import com.se.movie.simple.domain.payload.request.GetInternalApiRequest;
import com.se.movie.simple.domain.payload.request.InsertIntenalApiRequest;
import com.se.movie.simple.domain.payload.request.UpdateInternalApiRequest;
import com.se.movie.simple.domain.service.UserInternalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/internal")
public class UserInternalContrroller {

	private final UserInternalService userInternalService;
	
	@PostMapping("/getUser")
	public @ResponseBody String getUser(@Valid @RequestBody GetInternalApiRequest request) {
		try {
			Object data = userInternalService.doGetUser(request);
			
			return GeneratorCommonUtil.getResponseBodySuccess(data);
		} catch (Exception e) {
			return GeneratorCommonUtil.getResponseBodyError(List.of(e.getMessage()));
		}
	}
	
	@PostMapping("/insertUser")
	public @ResponseBody String insertUser(@Valid @RequestBody InsertIntenalApiRequest request) {
		try {
			List<User> userRequest = ObjectMapperCommonUtil.convertValue(request.getRecord(), new TypeReference<List<User>>() {});
			List<Integer> userIds = userInternalService.doInsertUser(userRequest);
			return GeneratorCommonUtil.getResponseBodySuccess(userIds);
		} catch (Exception e) {
			return GeneratorCommonUtil.getResponseBodyError(List.of(e.getMessage()));
		}
	}
	
	@PostMapping("/updateUser")
	public @ResponseBody String updateUser(@Valid @RequestBody UpdateInternalApiRequest request) {
		try {
			Integer userId = userInternalService.doUpdateUser(request);
			return GeneratorCommonUtil.getResponseBodySuccess(userId);
		} catch (Exception e) {
			return GeneratorCommonUtil.getResponseBodyError(List.of(e.getMessage()));
		}
	}
}
