package com.lee.pract.xdemoredis2021529.controller;

import com.lee.pract.xdemoredis2021529.entity.Lee;
import com.lee.pract.xdemoredis2021529.service.impl.LeeMybatisServiceImpl;
import com.lee.pract.xdemoredis2021529.status.ResponseCodeEnum;
import com.lee.pract.xdemoredis2021529.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/hello")
@CrossOrigin
public class HelloController {

    @Autowired
    private LeeMybatisServiceImpl leeMybatisServiceImpl;

    @GetMapping(value = "/hi/{id}/test")
    public ResponseResult helloX1Demo(@RequestParam(value = "userName", required = true) String userName,
                                      @RequestParam(value = "passWord", required = true) String passWord,
                                      @PathVariable(value = "id") Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", userName);
        map.put("passWord", passWord);
        map.put("id", id);
        ResponseResult responseResult = new ResponseResult(ResponseCodeEnum.SUCCESS, map);
        return responseResult;
    }

    @GetMapping(value = "/test")
    public Map test(String str) {
        Map map = new HashMap();
        map.put("tests", str);
        map.put("lxl", str);
        return map;
    }

    @GetMapping(value = "/db")
    public ResponseResult leeDB(@RequestParam(value = "name", required = true) String name) {
        List<Lee> list = leeMybatisServiceImpl.selectAllList(name);
        ResponseResult responseResult = new ResponseResult(ResponseCodeEnum.SUCCESS, list);
        return responseResult;
    }

}
