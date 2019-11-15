package com.fx.springsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @auther:
 * @date: 2019/11/15 14:04
 * @description:
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

/*    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http
        .authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .and()
        .httpBasic();
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                /**
                 * springSecurity 5 中必须加上密码编码规则，否则报错
                 * There is no PasswordEncoder mapped for the id “null”
                 */
                .passwordEncoder(passwordEncoder())
                .withUser("user1")
                .password(passwordEncoder().encode("user1"))
                /**
                 * 超级管理员用户
                 */
                .roles("ADMIN", "USER")
                .and()
                /**
                 * 普通用户
                 */
                .withUser("user2")
                .password(passwordEncoder().encode("user2"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/product/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().and()
                .httpBasic();

    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
