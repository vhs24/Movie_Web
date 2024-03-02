package com.se.movie.simple.controller.internal;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.se.movie.simple.domain.common.GeneratorCommonUtil;
import com.se.movie.simple.domain.entity.ProductionInfo;
import com.se.movie.simple.domain.payload.request.CreateInternalApiRequest;
import com.se.movie.simple.domain.payload.request.GetInternalApiRequest;
import com.se.movie.simple.domain.service.ProductionInfoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/production")
public class ProductionInfoInternalController {

	private final ProductionInfoService productionInfoService;

	@PostMapping("/insertProduction")
	@ResponseBody
	public String insertProduction(@RequestBody CreateInternalApiRequest<ProductionInfo> request) {
		try {
			List<String> results = productionInfoService.save(request.getRecords());
			return GeneratorCommonUtil.getResponseBodySuccess(results);
		} catch (Exception e) {
			return GeneratorCommonUtil.getResponseBodyError(List.of(e.getMessage()));
		}
	}

	@PostMapping("/getProduction")
	@ResponseBody
	public String getProduction(@RequestBody GetInternalApiRequest request) {
		try {
			List<ProductionInfo> results = productionInfoService.getProduction(request);
			return GeneratorCommonUtil.getResponseBodySuccess(results);
		} catch (Exception e) {
			return GeneratorCommonUtil.getResponseBodyError(List.of(e.getMessage()));
		}
	}
}
