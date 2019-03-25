package com.cloud.springboot.util.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description: Md5PasswordEncoder
 * @Company: 深圳市东深电子股份有限公司
 * @Auther: leichengyang
 * @Date: 2019/3/21 0021
 * @Version 1.0
 */
public class Md5PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }


    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence);
    }
}