package com.se.movie.simple.domain.db.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RUserInfoMapper {
	public List<Map<String, Object>> selectWhere(@Param("where") String where);
}
