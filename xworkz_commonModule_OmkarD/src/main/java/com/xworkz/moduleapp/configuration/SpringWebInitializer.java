package com.xworkz.moduleapp.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("Initializing Root Config Classes (for Database, Security, etc.)");
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("Initializing Servlet Config Classes (for MVC, Controllers, etc.)");
        return new Class[]{SpringModuleConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("Mapping DispatcherServlet to '/'");
        return new String[]{"/"};
    }
}
