package com.succos.controller;

import com.succos.utils.SUCCOSJSONResult;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author succos
 * @version 1.0
 * @date 2020/5/30 12:16
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public Object login(@RequestParam Map<String,Object> map){
        LinkedMultiValueMap<String, Object> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.set("username",map.get("username"));
        paramsMap.set("password",map.get("password"));
        paramsMap.set("grant_type",map.get("grant_type"));
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors()
                .add(new BasicAuthenticationInterceptor(
                        map.get("client_id").toString(),map.get("client_secret").toString())
                );
        OAuth2AccessToken oAuth2AccessToken = restTemplate.postForObject("http://localhost:9000/oauth/token", paramsMap, OAuth2AccessToken.class);
        return new SUCCOSJSONResult(oAuth2AccessToken);
    }


}
