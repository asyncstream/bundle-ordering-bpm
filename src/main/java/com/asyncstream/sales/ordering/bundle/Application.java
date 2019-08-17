package com.asyncstream.sales.ordering.bundle;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class Application implements WebApplicationInitializer {
    private  static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.register(ApplicationConfig.class);
        servletContext.addListener(new ContextLoaderListener(root));
    }
}
