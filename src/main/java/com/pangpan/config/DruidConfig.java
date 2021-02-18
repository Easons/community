package com.pangpan.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置Druid的属性
 */
//@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druid()
    {
        return new DruidDataSource();
    }


    //配置Druid的监控
    //1、配置一个管理后台的servlet

    @Bean
    public ServletRegistrationBean statViewServlet()
    {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        Map<String,String> map = new HashMap<String,String>();

        map.put("loginUsername","admin");
        map.put("loginPassword","123456");
        map.put("allow","");//默认就是允许所有
        map.put("deny","192.168.1.102");

        bean.setInitParameters(map);

        return bean;
    }


    @Bean
    public FilterRegistrationBean WebStatFilter()
    {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String> map = new HashMap<String,String>();

        map.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(map);

        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }

}
