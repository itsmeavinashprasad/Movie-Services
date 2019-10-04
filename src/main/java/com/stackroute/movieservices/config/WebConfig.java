package com.stackroute.movieservices.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("unchecked")
public class WebConfig {

    @Bean
    public ServletRegistrationBean h2ServletRegistration(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new WebServlet());
        servletRegistrationBean.addUrlMappings();
        return servletRegistrationBean;
    }
}