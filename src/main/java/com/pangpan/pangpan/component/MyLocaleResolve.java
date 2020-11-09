package com.pangpan.pangpan.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolve implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {

        String l = httpServletRequest.getParameter("l");

        Locale locale = Locale.getDefault();//如果没有区域信息，则获取默认的Locale
        if(!StringUtils.isEmpty(l))
        {//不为空则进行分割
           String [] split =  l.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
