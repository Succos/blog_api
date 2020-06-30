package com.succos.controller;

import com.succos.utils.SUCCOSJSONResult;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author succos
 * @version 1.0
 * @date 2020/5/30 12:16
 */
@RestController
@RequestMapping("/oauth")
public class OauthController {
    @PostMapping("/login")
    public SUCCOSJSONResult login(@RequestParam Map<String,Object> map){
        MultiValueMap<String,Object> paramsMap=new LinkedMultiValueMap<>();
        paramsMap.set("username",map.get("username"));
        paramsMap.set("password",map.get("password"));
        paramsMap.set("grant_type",map.get("grant_type"));
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(map.get("client_id").toString(),map.get("client_secret").toString()));
        OAuth2AccessToken token=restTemplate.postForObject("http://localhost:9000/oauth/token?client_id=client_vue&username=admin&password=123&grant_type=password&client_secret=123",null, OAuth2AccessToken.class);
        return new SUCCOSJSONResult(token);
    }


    @GetMapping("/info")
    public SUCCOSJSONResult info( HttpServletRequest request) throws UnsupportedEncodingException {
//          roles, name, avatar, introduction
        String authorization = request.getHeader("Authorization");
        String key = "imoocimoocimoocimooc";
        String token = StringUtils.substringAfter(authorization, "bearer ");
        if (StringUtils.isBlank(token)){
            token = authorization;
        }
        if (token != null){
            Claims claims = Jwts.parser().setSigningKey(key.getBytes("UTF-8")).parseClaimsJws(token).getBody();
            String company = (String)claims.get("company");
            String name = (String)claims.get("name");
            String avatar = (String)claims.get("avatar");
            String introduction = (String)claims.get("introduction");
            Map<String, String> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("name",name);
            stringStringHashMap.put("company",company);
            stringStringHashMap.put("avatar",avatar);
            stringStringHashMap.put("introduction",introduction);
            return new SUCCOSJSONResult(stringStringHashMap);
        }
        return SUCCOSJSONResult.errorMsg("token不存在");

    }
}
