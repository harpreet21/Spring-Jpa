package com.scorpion;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerRestApplication {

	@Bean  
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
	  	
		return hemf.getSessionFactory();  
	} 
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerRestApplication.class, args);
	}
	
}
