package com.zensar.jobcentral;

/**
 * @author Gourab Sarkar
 * @modification_date 17 Oct 2019 06:55
 * @creation_date 17 Oct 2019 06:55
 * @version 0.1
 * @copyright Zensar Technologies 2019. All Rights Reserved.
 * @description This is the main class of the application.
 */

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class
})		
public class JobCentralApplication {

	@Autowired
	private Environment env;
	
	public static void main(String[] args) 
	{	
		SpringApplication.run(JobCentralApplication.class, args);
		System.err.println("Debug: JobCentralApplication run executed successfully!");
	}
	
	@Bean(name = "dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		// See: Application properties
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		
		System.err.println("Debug: getDataSource :: " + dataSource);
		
		return dataSource;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) throws Exception 
	{
		Properties properties = new Properties();
		System.err.println("Debug: In getSessionFactory");
		
		// See application: properties
		properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
		System.err.println("Debug: Hibernate properties set :: " + properties);
		
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		
		// Package containing entity classes
		factoryBean.setPackagesToScan(new String[] {"com.zensar"});
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(properties);
		factoryBean.afterPropertiesSet();
		System.err.println("Debug: factoryBean object set :: " + factoryBean);
		
		SessionFactory sessionFactory = factoryBean.getObject();
		System.err.println("Debug: getSessionFactory object: " + sessionFactory);
		
		return sessionFactory;
	}
	
	@Autowired
	@Bean(name = "hibernateTemplate")
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) 
	{
		System.err.println("Debug: In getHibernateTemplate.");
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		return hibernateTemplate;
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.err.println("Debug: In hibernateTransactionManager");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}


}
