package com.nrb.maledisease.auth.config;

import com.nrb.maledisease.auth.handle.RestAuthenticationEntryPoint;
import com.nrb.maledisease.auth.handle.RestAuthenticationFailureHandler;
import com.nrb.maledisease.auth.handle.RestAuthenticationSuccessHandler;
import com.nrb.maledisease.auth.handle.RestLogoutSuccessHandler;
import com.nrb.maledisease.auth.service.AuthService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * Created by zhangyunfei on 27/11/2016.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private AuthService authService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/index", "/login", "/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //登陆成功后的处理，因为是API的形式所以不用跳转页面
                .successHandler(new RestAuthenticationSuccessHandler())
                //登陆失败后的处理
                .failureHandler(new RestAuthenticationFailureHandler())
                .and()
                //登出后的处理
                .logout().logoutSuccessHandler(new RestLogoutSuccessHandler())
                .and()
                //认证不通过后的处理
                .exceptionHandling()
                .authenticationEntryPoint(new RestAuthenticationEntryPoint());
    }

}