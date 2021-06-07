package com.lee.pract.xdemoredis2021529.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lee.pract.xdemoredis2021529.status.ResponseCodeEnum;
import com.lee.pract.xdemoredis2021529.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/rest")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @Value(value = "${base.url}")
    private String BASE_URL;

    @RequestMapping(value = "/get")
    public ResponseResult rest(@RequestHeader(name = "x-transaction-id", required = false) String x_transaction_id,
                               @RequestHeader(name = "sourceCode", defaultValue = "MINI-WECHAT", required = false) String sourceCode,
                               @RequestHeader(name = "x-customer-id") String customerId) {
        String URL = BASE_URL + "/api/wx/v1/account/detail";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-customer-id", customerId);
        httpHeaders.add("sourceCode", sourceCode);
        httpHeaders.add("x-transaction-id", x_transaction_id);
        Map<String, String> postParameters = new HashMap<>();
        postParameters.put("sign","ignore");
        postParameters.put("nonce","123445");
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(postParameters, httpHeaders);
        HttpEntity<JSONObject> result = restTemplate.postForEntity(URL, httpEntity, JSONObject.class);
        Integer code = ((ResponseEntity<JSONObject>)result).getStatusCode().value();
        ResponseResult responseResult = null;
        if (code == HttpStatus.OK.value()) {
            responseResult = new ResponseResult(ResponseCodeEnum.SUCCESS, result.getBody());
        } else {
            JSONObject JSONObj = JSON.parseObject(JSON.toJSONString(result.getBody()));
            responseResult = new ResponseResult(ResponseCodeEnum.DATA_NOT_EXIST, JSONObj);
        }
        return responseResult;
    }

}
