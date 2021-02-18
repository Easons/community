package com.pangpan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan//为了加在Druid线程池
//@SpringBootApplication 标注这个类是一个springboot的应用
@SpringBootApplication
public class PangpanApplication {
    //将springboot应用启动
    public static void main(String[] args) {
        SpringApplication.run(PangpanApplication.class, args);
    }

}
