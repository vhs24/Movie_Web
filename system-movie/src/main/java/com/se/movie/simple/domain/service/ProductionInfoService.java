package com.se.movie.simple.domain.service;

import java.util.List;

import com.se.movie.simple.domain.entity.ProductionInfo;
import com.se.movie.simple.domain.payload.request.GetInternalApiRequest;

public interface ProductionInfoService {

	List<String> save(List<ProductionInfo> records) throws Exception;

	List<ProductionInfo> getProduction(GetInternalApiRequest request) throws Exception;

}
