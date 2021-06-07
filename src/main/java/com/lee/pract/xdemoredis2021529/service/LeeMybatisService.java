package com.lee.pract.xdemoredis2021529.service;

import com.lee.pract.xdemoredis2021529.entity.Lee;

import java.util.List;

public interface LeeMybatisService {

    List<Lee> selectAllList(String name);

}
