package com.devicespringboot.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.devicespringboot"})

/*
 *  dont need to declare @Repository in interface cuz we have @EnableJpaRepositories
 *  
 */
@EnableJpaRepositories(basePackages = {"com.devicespringboot.repository"})
@EnableJpaAuditing(auditorAwareRef = "auditorRef")
public class WebConfig implements WebMvcConfigurer {
	
	/* 
	 * when create bean in @Configuration, this bean will have a singleton scope 
	 * (singleton bean create at firstly and use for entire application ) 
	 * 
	 */
	
	@Override
	@Description("Serve static resources such as images, js, and, cssfiles ")
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**")
				.addResourceLocations("/assets/");
	}
	
	@Override
	@Description("config mapping path for jsp view")
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		registry.viewResolver(resolver);
	}
	
	@Bean(name = "dataSource")
	@Description("create datasource for connection")
	public DataSource getDataSource() {
		DataSourceBuilder<?> builder = DataSourceBuilder.create();
		builder.driverClassName("com.mysql.cj.jdbc.Driver");
		builder.url("jdbc:mysql://localhost:3306/springdevicedatabase?createDatabaseIfNotExist=true");
		builder.username("root");
		builder.password("123456");
		return builder.build();
	}
	
	public Properties getProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		prop.put("hibernate.hbm2ddl.auto","update");
		prop.put("hibernate.show_sql","true");
		return prop;
	}
	
	@Bean(name = "entityManagerFactory")
	@Description("Create sessionfatory of hibernate")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getProperties());
		builder.scanPackages("com.devicespringboot.entity");
		return builder.buildSessionFactory();
	}
	
	@Bean
	@Description("enable jpa auditing")
	public JpaAuditing auditorRef() {
		return new JpaAuditing();
	}
	
	@Bean
	@Description("filter view when mapping url")
	public FilterRegistrationBean<SiteMeshFilter> sitemeshFilter(){
		FilterRegistrationBean<SiteMeshFilter> filter = new FilterRegistrationBean<>();
		filter.setFilter(new SiteMeshFilter());
		return filter;
	}
	
	
	
}
