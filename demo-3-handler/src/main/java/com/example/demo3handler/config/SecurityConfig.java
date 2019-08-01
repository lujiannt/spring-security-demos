package com.example.demo3handler.config;

import com.example.demo3handler.handler.MyAuthFailureHandler;
import com.example.demo3handler.handler.MyAuthSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAuthSuccessHandler myAuthSuccessHandler;
    @Autowired
    private MyAuthFailureHandler myAuthFailureHandler;

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
                //配置自定义登录页面
                .loginPage("/openToLogin")
                //配置自定义的登录表单action
                .loginProcessingUrl("/login")
                //配置自定义的登录表单中的用户名与密码
                .usernameParameter("uname")
                .passwordParameter("pwd")
                //注册登录成功/失败处理器
                .successHandler(myAuthSuccessHandler)
                .failureHandler(myAuthFailureHandler)
                .and()
                .httpBasic();
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }
}
