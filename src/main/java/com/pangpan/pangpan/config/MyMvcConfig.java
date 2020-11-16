package com.pangpan.pangpan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//扩展springMvc
@Configuration
//@EnableWebMvc //加了这个类，整个WebMvc的自动配置就失效了，因为WebMvc里面有个条件注解：WebMvcConfigurationSupport ，当这个类
                //存在的话，自动配置就失效了，所以spring的官网标粗了，扩展不能添加此注解。
public class MyMvcConfig implements WebMvcConfigurer {

//如果你想自己定制一些功能，只要写这个组件，然后将他交给springBoot，springboot就会帮我们自动装配
//ViewResolver 实现了视图解析器接口的类，我们就可以把它看作视图解析器
//    @Bean
//    public ViewResolver myViewResolver(){
//        return new MyViewResolver();
//    }
//
//    public static class MyViewResolver implements ViewResolver {
//
//        @Override
//        public View resolveViewName(String s, Locale locale) throws Exception {
//            return null;
//        }
//    }

//    @Bean
//    public WebMvcConfigurerAdapter webMvcConfigureerAdapter(){
//
//        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/index.html").setViewName("login");
//                registry.addViewController("/main.html").setViewName("dashboard");
//
//                super.addViewControllers(registry);
//            }
//        };
//
//        return adapter;
//    }

//    @Bean
//    public LocaleResolver localeResolver(){
//        return  new MyLocaleResolve();
//    }
}
