package com.anikitin.library.config;

import com.anikitin.library.security.config.WebSecurityConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by anikitin on 28.09.2016.
 */
@Configuration
@ComponentScan(basePackages = {"com.anikitin.library"}
,excludeFilters={
        @ComponentScan.Filter(type= FilterType.ANNOTATION, value=EnableWebMvc.class)
}
)
@ContextConfiguration(classes = {JpaConfig.class, WebSecurityConfiguration.class})
@ImportResource("classpath:ws-config.xml")
public class Config {
}
