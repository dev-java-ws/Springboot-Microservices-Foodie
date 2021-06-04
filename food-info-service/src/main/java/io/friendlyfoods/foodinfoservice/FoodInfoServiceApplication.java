package io.friendlyfoods.foodinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author devia
 * FoodInfo service Microservice - http://localhost:8083/food/101
 * 
 * output-> foodId	"101" name	"Pasta"
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class FoodInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodInfoServiceApplication.class, args);
	}

}
