package com.succos.security.auth;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author succos
 * @version 1.0
 * @date 2020/6/18 0:16
 */
public class SuccosJwtTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Object principal = oAuth2Authentication.getPrincipal();
        System.out.println("------------->"+principal);
        Map<String,Object> info = new HashMap<>();
        //  name, avatar, introduction
        info.put("company","gongsi");
        info.put("name","name");
        info.put("avatar","avatar");
        info.put("introduction","introduction");
//        info.put("role",role.toString());
        //  roles, name, avatar, introduction

        ((DefaultOAuth2AccessToken)oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }
}
