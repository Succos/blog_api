package com.succos.security.auth;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author succos
 * @version 1.0
 * @date 2020/6/16 0:06
 */
@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authorization = httpServletRequest.getHeader("Authorization");
        String key = "imoocimoocimoocimooc";
        String token = StringUtils.substringAfter(authorization, "bearer ");
        if (token != null){
//            Claims claims = Jwts.parser().setSigningKey(key.getBytes("UTF-8")).parseClaimsJws(token).getBody();
//            String company = (String)claims.get("company");
//            System.out.println("--->"+company);
//            String json = EncryptUtil.decodeUTF8StringBase64(token);
//            JSONObject jsonObject = JSON.parseObject(json);
//            // 用户信息
//            String principal = jsonObject.getString("principal");
//            // 权限信息
//            User userDTO = new User();
//            userDTO.setUsername(principal);
//
//            //获取权限信息
//            JSONArray authoritiesArray = jsonObject.getJSONArray("authorities");
//            String[] authorities=authoritiesArray.toArray(new String[authoritiesArray.size()]);
//            //将用户身份权限信息填充到用户token对象中
//            UsernamePasswordAuthenticationToken authenticationToken
//                    = new UsernamePasswordAuthenticationToken(userDTO,null, AuthorityUtils.createAuthorityList(authorities));
//            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
//            //将authenticationToken填充到安全上下文
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
