package com.xbao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication(/*exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class}*/)
public class PCWebApp {

	 public static void main(String[] args) {
		 SpringApplication.run(PCWebApp.class, args);
	}
	
}
