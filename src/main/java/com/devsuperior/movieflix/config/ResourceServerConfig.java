package com.devsuperior.movieflix.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private JwtTokenStore tokenStore;

    @Autowired
    private Environment env;

    private static final String[] PUBLIC = {"/oauth/token", "/h2-console/**"};

    private static final String[] VISITOR_OR_MEMBER_GET = {"/genres/**", "/movies/**"};

    private static final String[] MEMBER_EDIT = {"/reviews/**"};

//    private static final String[] ADMIN = {"/users/**"};

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // H2
        if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        http
                .authorizeRequests()
                .antMatchers(PUBLIC).permitAll()
                .antMatchers(HttpMethod.GET, VISITOR_OR_MEMBER_GET).hasAnyRole("VISITOR", "MEMBER")
                .antMatchers(HttpMethod.POST, MEMBER_EDIT).hasRole("MEMBER")
                .antMatchers(HttpMethod.PUT, MEMBER_EDIT).hasRole("MEMBER")
                .antMatchers(HttpMethod.DELETE, MEMBER_EDIT).hasRole("MEMBER")
//                .antMatchers(ADMIN).hasRole("ADMIN")
                .anyRequest().denyAll()
        ;
    }
}
