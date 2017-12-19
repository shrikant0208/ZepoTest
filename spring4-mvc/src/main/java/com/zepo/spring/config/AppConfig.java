package com.zepo.spring.config;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.zepo.spring.constants.DataSourceAttributes;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.zepo.spring")
@PropertySource("classpath:zepo_query.properties")
public class AppConfig extends WebMvcConfigurerAdapter {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
	    return new PropertySourcesPlaceholderConfigurer();
	}
	

	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DataSourceAttributes.DRIVER_CLASS_NAME.attributeValue());
        dataSource.setUrl(DataSourceAttributes.DATABASE_URL.attributeValue());
        dataSource.setUsername(DataSourceAttributes.DATABASE_USERNAME.attributeValue());
        dataSource.setPassword(DataSourceAttributes.DATABASE_PASSWORD.attributeValue());
        
        /*dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_sarto");
        dataSource.setUsername("root");
        dataSource.setPassword("P@55w0rd");*/
         
        return dataSource;
    }
	
	
	@Bean(name = "mappingNamedParameterJdbcTemplate")
	@Qualifier("mappingNamedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate getMappingNamedParameterJdbcTemplate(){
		return new NamedParameterJdbcTemplate(getDataSource());
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}