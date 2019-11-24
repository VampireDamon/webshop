package com.damon.bgmt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {
    private static String BEARER_AUTHENTICATION = "Bearer";

    private static String HEADER_AUTHENTICATION = "authorization";

    @Autowired
    private RedisConnectionFactory redisConnection;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String auth = httpServletRequest.getHeader(HEADER_AUTHENTICATION);
        String token = httpServletRequest.getParameter("access_token");

        MyRedisTokenStore myRedisTokenStore = new MyRedisTokenStore(redisConnection);
        if (auth != null && auth.startsWith(BEARER_AUTHENTICATION)) {
            token = token.split(" ")[0];
        }
        if (token != null) {
            OAuth2AccessToken accessToken = myRedisTokenStore.readAccessToken(token);
            if (accessToken != null) {
                myRedisTokenStore.removeAccessToken(accessToken);
            }
        }
    }


}
