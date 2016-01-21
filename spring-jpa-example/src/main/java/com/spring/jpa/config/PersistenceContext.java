package com.spring.jpa.config;

/**
 * 
 * @author ariel.duarte
 */

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.spring.jpa.BasePackage;
import com.spring.jpa.GlobalProperties;


@Configuration
@EnableJpaRepositories(basePackageClasses = BasePackage.class)
public class PersistenceContext {
	
	@Inject
	GlobalProperties globalProperties;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(globalProperties.getDataSourceDriver());
		dataSource.setUrl(this.globalProperties.getDataSourceUrl());
		dataSource.setUsername(this.globalProperties.getDataSourceUsername());
		dataSource.setPassword(this.globalProperties.getDataSourcePassword());
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(this.dataSource());
		em.setPackagesToScan(BasePackage.class.getPackage().getName());
		em.setJpaPropertyMap(this.jpaPropertyMap());
		HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
		vendor.setDatabase(Database.MYSQL);
		vendor.setShowSql(false); 
		em.setJpaVendorAdapter(vendor);
		
		return em;
	}
	
	 @Bean
	   public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(emf);
	 
	      return transactionManager;
	   }
	
	@Bean
	public Map<String, ?> jpaPropertyMap() {
		Map<String, Object> jpaPropertyMap = new HashMap<String, Object>();
		jpaPropertyMap.put("hibernate.dialect",	"org.hibernate.dialect.MySQLDialect");
						
		/* This is an alternative to setting the log4j category "org.hibernate.SQL" to debug */
		jpaPropertyMap.put("hibernate.show_sql", "false");
		jpaPropertyMap.put("hibernate.format_sql", "true");
		jpaPropertyMap.put("hibernate.use_sql_comments", "true");
        
		return jpaPropertyMap;
	}

}
