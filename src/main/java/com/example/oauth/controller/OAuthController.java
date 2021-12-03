package com.example.oauth.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * OAuthController
 *
 * @author Administrator
 * @since 2021/12/3
 */
@RestController
@RequestMapping("/oauth")
public class OAuthController {
    private final static String access_token_uri = "http://localhost:8888/oauth-server/oauth/token";
    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/token")
    public Object getToken(@RequestBody Map<String, String> params){
       // restTemplate.setMessageConverters(getConverts());
        HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.setAll(params);
        HttpEntity<Map<String, String>> body = new HttpEntity<>(params, headers);
        return restTemplate.postForObject(access_token_uri, paramsMap, JSONObject.class);
    }



    private List<HttpMessageConverter<?>> getConverts() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        // String转换器
        StringHttpMessageConverter stringConvert = new StringHttpMessageConverter();
        List<MediaType> stringMediaTypes = new ArrayList<MediaType>() {{
            //添加响应数据格式，不匹配会报401
            add(MediaType.TEXT_PLAIN);
            add(MediaType.TEXT_HTML);
            add(MediaType.APPLICATION_JSON);
        }};
        stringConvert.setSupportedMediaTypes(stringMediaTypes);
        messageConverters.add(stringConvert);
        return messageConverters;
    }
}
