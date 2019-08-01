package com.example.demo1basic.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 自定义简单密码编码器
 */
public class SecurityPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
