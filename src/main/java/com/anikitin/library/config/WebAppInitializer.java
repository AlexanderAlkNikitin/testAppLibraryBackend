//package com.anikitin.library.config;

import com.anikitin.library.security.config.WebSecurityConfiguration;
import com.anikitin.library.security.filter.AuthenticationTokenFilter;
import com.sun.xml.ws.transport.http.servlet.WSSpringServlet;
import org.springframework.security.access.SecurityConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by anikitin on 28.09.2016.
 */
////public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//public class WebAppInitializer implements WebApplicationInitializer {
////    @Override
////    protected Class<?>[] getRootConfigClasses() {
////        return new Class<?>[]{Config.class};
////    }
////
////    @Override
////    protected Class<?>[] getServletConfigClasses() {
////        return new Class<?>[]{WebConfig.class};
////    }
////
////    @Override
////    protected String[] getServletMappings() {
////        return new String[]{"/"};
////    }
////
////    @Override
////    protected Filter[] getServletFilters() {
////        return new Filter[]{
////                new AuthenticationTokenFilter()
////        };
////    }
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//        rootContext.register(Config.class, WebSecurityConfiguration.class);
//
//        // Manage the lifecycle of the root application context
//        servletContext.addListener(new ContextLoaderListener(rootContext));
//
//        servletContext.addFilter("securityFilter",new AuthenticationTokenFilter());
//        // Create the dispatcher servlet's Spring application context
//        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
//        dispatcherServlet.register(WebConfig.class);
//
//        // Register and map the dispatcher servlet
//        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
//        dispatcher.setLoadOnStartup(2);
//        dispatcher.addMapping("/");
//        ServletRegistration.Dynamic dynamic=servletContext.addServlet("ws",new WSSpringServlet());
//        dynamic.setLoadOnStartup(1);
//        dynamic.addMapping("/ws/*");
//    }
//}
