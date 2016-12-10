package com.nrb.maledisease.patient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * Created by zhangyunfei on 02/12/2016.
 */
@Configuration
public class PassEncoderConfig {

    @Value("${patient.seckey}")
    private String seckey;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder(seckey);
    }
}
