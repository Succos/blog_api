package com.succos.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author succos
 * @version 1.0
 * @date 2020/6/14 10:55
 */
@Configuration
public class TokenStoreConfig {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public TokenStore redisTokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Configuration
   public static class JwtTokenConfig{

       @Bean
       public TokenStore jwtTokenStore() {
           return new JwtTokenStore(jwtAccessTokenConverter());
       }


       @Bean
       public JwtAccessTokenConverter jwtAccessTokenConverter() {
           JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
           //对称秘钥，资源服务器使用该秘钥来验证
           accessTokenConverter.setSigningKey("imoocimoocimoocimooc");
           return accessTokenConverter;
       }

       @Bean
       @ConditionalOnMissingBean(name = "jwtTokenEnhancer")
       public TokenEnhancer jwtTokenEnhancer(){
           return new SuccosJwtTokenEnhancer();
       }
    }


}
