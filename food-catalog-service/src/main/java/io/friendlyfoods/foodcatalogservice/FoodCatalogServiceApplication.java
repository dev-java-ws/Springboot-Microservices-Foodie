package io.friendlyfoods.foodcatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/*
 * This spring boot microservice application gives a list of food items for the given user
 * http://localhost:8082/catalog/23
 * 
 * o/p  - name	"Pasta" description	"Delicious pasta" rating	4
 */
@SpringBootApplication
@EnableEurekaClient
public class FoodCatalogServiceApplication {

	@Bean
	@LoadBalanced // this gets the uri for the req microservice from discovery server, and the library calls the same uri in a load balanced way
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FoodCatalogServiceApplication.class, args);
	}

}
