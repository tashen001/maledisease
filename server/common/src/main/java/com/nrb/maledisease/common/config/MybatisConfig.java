package com.nrb.maledisease.common.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.github.pagehelper.PageHelper;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MybatisConfig {

	@Bean
	public PageHelper pageHelper() {
		//分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		properties.setProperty("offsetAsPageNum", "true");
		properties.setProperty("rowBoundsWithCount", "true");
		pageHelper.setProperties(properties);
		return pageHelper;
	}

	@Bean
	public ServletRegistrationBean duridServletRegistrationBean(){
		StatViewServlet servlet = new StatViewServlet();
		ServletRegistrationBean registration = new ServletRegistrationBean(servlet);
		registration.setEnabled(true);
		registration.addUrlMappings("/druid/*");
		return registration;
	}
}