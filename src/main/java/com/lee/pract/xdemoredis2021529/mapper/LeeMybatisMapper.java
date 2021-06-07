package com.lee.pract.xdemoredis2021529.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LeeMybatisMapper <T> {

    List<T> selectAllList(@Param(value = "name") String name);

}
