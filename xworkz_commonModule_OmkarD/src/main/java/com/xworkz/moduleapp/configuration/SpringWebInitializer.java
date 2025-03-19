package com.xworkz.moduleapp.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("getRootConfigClasses object is invoked");
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("getServletConfigClasses object is invoked");
        return new Class[]{SpringModuleConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("getServletMappings object is invoked");
        return new String[]{"/"};
    }
}
