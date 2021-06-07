package com.lee.pract.xdemoredis2021529.controller;

import com.lee.pract.xdemoredis2021529.status.ResponseCodeEnum;
import com.lee.pract.xdemoredis2021529.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping(value = "/set")
    public ResponseResult redisTestSet(@RequestParam(value = "K", required = true) String K,
                                       @RequestParam(value = "V", required = true) String V,
                                       @RequestParam(value = "exp", required = false) Integer exp) {
        redisTemplate.opsForValue().set(K, V, exp, TimeUnit.SECONDS);
        Map map = new HashMap<>();
        map.put("K", K);
        map.put("V", V);
        ResponseResult responseResult = new ResponseResult(ResponseCodeEnum.SUCCESS, map);
        return responseResult;
    }

    @GetMapping(value = "/get")
    public ResponseResult redisTestGet(@RequestParam(value = "K", required = true) String K) {
        Object obj = redisTemplate.opsForValue().get(K);
        if (obj == null) {
            return new ResponseResult(ResponseCodeEnum.DATA_NOT_EXIST, null);
        }
        
        Map map = new HashMap<>();
        map.put("K", K);
        map.put("result", obj.toString());
        ResponseResult responseResult = new ResponseResult(ResponseCodeEnum.SUCCESS, map);
        return responseResult;
    }


}
