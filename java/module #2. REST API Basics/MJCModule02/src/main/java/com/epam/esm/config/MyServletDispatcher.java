package com.epam.esm.config;


import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


public class MyServletDispatcher
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    public static final String DEV_PROFILE = "dev";
    public static final String PROD_PROFILE = "prod";
    public static final String ACTIVE_PROFILE_PARAM = "spring.profiles.active";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.setInitParameter(ACTIVE_PROFILE_PARAM, DEV_PROFILE);
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected WebApplicationContext createServletApplicationContext() {
        WebApplicationContext context = super.createServletApplicationContext();
        ((ConfigurableEnvironment) context.getEnvironment()).setActiveProfiles(DEV_PROFILE);
        return context;
    }

}
