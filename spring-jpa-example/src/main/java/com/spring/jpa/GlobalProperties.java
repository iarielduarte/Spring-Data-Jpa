package com.spring.jpa;

import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;

/**
 * 
 * @author ariel.duarte
 */
@Named
@Getter
@Setter
public class GlobalProperties {

   
	/*
	 * MYSQL properties.
	 */
	@Value("${dataSource.driver}")
	private String dataSourceDriver;
	@Value("${dataSource.url}")
	private String dataSourceUrl;	
	@Value("${dataSource.username}")
	private String dataSourceUsername;
	@Value("${dataSource.password}")
	private String dataSourcePassword;
}
