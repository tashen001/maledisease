package com.nrb.maledisease.patient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * Created by zhangyunfei on 02/12/2016.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

//    @Resource
//    private PatientInterceptor patientInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(patientInterceptor);
//    }

}
