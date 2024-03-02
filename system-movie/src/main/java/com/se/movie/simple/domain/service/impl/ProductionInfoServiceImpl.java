package com.se.movie.simple.domain.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.movie.simple.domain.db.read.RProductionInfoMapper;
import com.se.movie.simple.domain.entity.ProductionInfo;
import com.se.movie.simple.domain.payload.request.GetInternalApiRequest;
import com.se.movie.simple.domain.repository.ProductionInfoRepository;
import com.se.movie.simple.domain.service.ProductionInfoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductionInfoServiceImpl implements ProductionInfoService {
	
	private final ProductionInfoRepository repository;
	private final RProductionInfoMapper mapper;
	private final ObjectMapper objectMapper;
	
	@Override
	public List<String> save(List<ProductionInfo> records) throws Exception {
		try {
			List<ProductionInfo> productionInfos = repository.saveAll(records);
			return productionInfos.stream()
					.map(ProductionInfo::getId)
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public List<ProductionInfo> getProduction(GetInternalApiRequest request) throws Exception {
		try {
			List<Map<String, Object>> results = mapper.selectWhere(request.getConditionStr(), request.getLimit(), request.getOffset(), request.getOrderBys());
			List<ProductionInfo> productionInfos = objectMapper.convertValue(results, new TypeReference<List<ProductionInfo>>() {});
			return productionInfos;
		} catch (Exception e) {
			throw new Exception();
		}
	}

}
