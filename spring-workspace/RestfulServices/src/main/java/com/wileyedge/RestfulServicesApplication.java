package com.wileyedge;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestfulServicesApplication {
		@Profile("dev")
		@Bean
		public String devdbConnection() {
			System.out.println("DB fro dev_in h2 in memory");
			return "DB for dev_-in h2 in memory";
		}
		@Profile("prod")
		@Bean
		public String proddbConnection() {
			System.out.println("DB fro prod_-mysql Database");
			return "DB fro prod_-mysql Database";
		}
	
	
	public static void testOnetoOne(ApplicationContext context) {
		EntityManagerFactory emf=context.getBean("entityManagerFactory",EntityManagerFactory.class);
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Employee e=new Employee("Rashmi");
		em.persist(e);
		tx.commit();
		
	}
	
	@Bean(name="resttemplate")
	public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	}
	public static String consumeGetRestApis(RestTemplate restemplate) {
		//consume GET Apis
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
			      
	    return restemplate.exchange("http://localhost:9898/users", HttpMethod.GET, entity, String.class).getBody();
	}
	public static String consumePostRestApis(RestTemplate restemplate,User user) {
		//consume GET Apis
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    //HttpEntity <String> entity = new HttpEntity<String>(headers);
	    HttpEntity<User> entity = new HttpEntity<User>(user,headers);
			      
	    return restemplate.exchange("http://localhost:9898/users", HttpMethod.POST, entity, String.class).getBody();
	}

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(RestfulServicesApplication.class, args);
		testOnetoOne(context);
		User user = new User(420,"John",new Date());
		RestTemplate restemplate = context.getBean("resttemplate",RestTemplate.class);
		String result1 = consumePostRestApis(restemplate,user);
		System.out.println("result1:" + result1);
		String result2 = consumeGetRestApis(restemplate);
		System.out.println("result2:" + result2);
	}

}
