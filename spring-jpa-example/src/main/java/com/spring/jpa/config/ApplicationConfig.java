package com.spring.jpa.config;

import javax.inject.Named;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.spring.jpa.BasePackage;

/**
 * 
 * @author ariel.duarte
 */

@Configuration
@ComponentScan(basePackageClasses = BasePackage.class, includeFilters = { @Filter(Service.class),
        @Filter(Repository.class), @Filter(Named.class) }, useDefaultFilters = false)
@Import({ PropertyConfig.class, PersistenceContext.class })
public class ApplicationConfig {

}
