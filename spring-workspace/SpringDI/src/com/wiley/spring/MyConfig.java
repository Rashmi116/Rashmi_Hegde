package com.wiley.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration   //replacement of entire XML
@ComponentScan(basePackages = "com.wiley.spring")//replacemnet of entry <bean id="e3" class="wiley.spring.employee>
public class MyConfig {
	@Bean(name = "a4")
	
	public Address getAddr1() {
		Address a=new Address(1234,"Banglore","India");
		return a;
	}
	@Bean(name = "a5")
	@Primary
	public Address getAddr2() {
		Address a=new Address(12345,"Mysuru","India");
		return a;
	}

}
