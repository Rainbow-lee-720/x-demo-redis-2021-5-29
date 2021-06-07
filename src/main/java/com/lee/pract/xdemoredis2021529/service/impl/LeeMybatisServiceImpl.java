package com.lee.pract.xdemoredis2021529.service.impl;

import com.lee.pract.xdemoredis2021529.entity.Lee;
import com.lee.pract.xdemoredis2021529.mapper.LeeMybatisMapper;
import com.lee.pract.xdemoredis2021529.service.LeeMybatisService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LeeMybatisServiceImpl implements LeeMybatisService {

    @Autowired
    private LeeMybatisMapper<Lee> leeLeeMybatisMapper;

    private Logger logger = LoggerFactory.getLogger(LeeMybatisServiceImpl.class);

    @Override
    public List<Lee> selectAllList(String name) {
        logger.info("start=====> params:name:{}", name);
        List<Lee> list = leeLeeMybatisMapper.selectAllList(name);
        logger.info("end=====> result:list:{}", list);
        return list;
    }
}
