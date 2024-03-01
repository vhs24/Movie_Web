package com.se.movie.simple.domain.common;

import io.micrometer.common.lang.NonNull;
import lombok.Data;

@Data
public class UpdateInternalApiRequest {
	@NonNull
	private String updateSet;
	@NonNull
	private String conditionStr;
}
