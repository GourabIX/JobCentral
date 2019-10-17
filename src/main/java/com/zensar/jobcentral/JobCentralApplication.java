package com.zensar.jobcentral;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
public class JobCentralApplication {

	@Autowired
	private Environment env;
	
	public static void main(String[] args) 
	{	
		SpringApplication.run(JobCentralApplication.class, args);	
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
		
		System.out.println("Debug--> getDataSource: " + dataSource);
		
		return dataSource;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) throws Exception 
	{
		Properties properties = new Properties();
		
		// See application: properties
		properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
		
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		
		// Package containing entity classes
		factoryBean.setPackagesToScan(new String[] {"com.zensar.jobcentral.entities"});
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(properties);
		factoryBean.afterPropertiesSet();
		
		SessionFactory sessionFactory = factoryBean.getObject();
		System.out.println("getSessionFactory object: " + sessionFactory);
		
		return sessionFactory;
	}
	
	@Autowired
	@Bean(name = "hibernateTemplate")
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) 
	{
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		return hibernateTemplate;
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}


}
