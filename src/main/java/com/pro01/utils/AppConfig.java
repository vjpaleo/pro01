package com.pro01.utils;

import org.springframework.core.env.Environment;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableWebMvc
@ComponentScan(basePackages={"com.pro01.controllers", "com.pro01.model"}
	/*, excludeFilters = { @Filter(type = FilterType.ANNOTATION, value = Configuration.class) }*/)
@PropertySource("classpath:com/pro01/assets/dbInfo.properties")
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	Environment env;

	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
	@Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	/*
	@Bean
	public DriverManagerDataSource myDriverManagerDataSource () {
		
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		
		dmds.setDriverClassName(env.getProperty("dbDriver"));//"com.mysql.jdbc.Driver");
		dmds.setUrl("jdbs:mysql://localhost:3306/pro01db");
		dmds.setUsername("root");
		dmds.setPassword("root");
		
		return dmds;
	}
	*/
	
	@Bean
	public BasicDataSource myBasicDataSource() {
		System.out.println("Connecting to database.");
		
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(env.getProperty("dbDriver"));
		bds.setUrl(env.getProperty("dbUrl"));
		bds.setUsername("root");
		bds.setPassword("root");
	
		return bds;
	}
	
	@Override
	public void addResourceHandlers (ResourceHandlerRegistry registry) {
		System.out.println("addResourceHandlers");
		registry.addResourceHandler("/myResources/**").addResourceLocations("/resources/");
	}

}
