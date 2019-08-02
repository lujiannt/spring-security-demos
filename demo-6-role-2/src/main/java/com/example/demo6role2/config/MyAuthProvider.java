package com.example.demo6role2.config;

import com.example.demo6role2.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 自定义登录校验器
 */
@Component
public class MyAuthProvider implements AuthenticationProvider {
    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;
    private static UserDetailServiceImpl userDetailService;

    @PostConstruct
    public void setService() {
        userDetailService = userDetailServiceImpl;
    }

    /**
     * 进行登录用户名密码校验
     *
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取用户输入的用户名和密码
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        // 获取封装用户信息的对象
        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        // 进行密码的比对
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        SecurityPasswordEncoder passwordEncoder = new SecurityPasswordEncoder();
        boolean flag = passwordEncoder.matches(password, userDetails.getPassword());
        // 校验通过
        if (flag) {
            // 将权限信息也封装进去
            return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        }

        // 验证失败返回 null
        return null;

    }

    /**
     * 开启自定义支持
     *
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }


}
