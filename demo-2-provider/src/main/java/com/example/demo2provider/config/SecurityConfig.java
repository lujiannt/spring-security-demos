package com.example.demo2provider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("auth configure");
        //启用自定义校验器，动态从数据库比对用户名密码
        auth.authenticationProvider(new MyAuthProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("http configure");
        http.authorizeRequests()
                .antMatchers("/openToLogin", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
//                .loginPage("/openToLogin")
//                .permitAll()
                .and()
                .httpBasic();
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }
}
