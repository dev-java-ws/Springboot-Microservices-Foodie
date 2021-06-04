package io.friendlyfoods.foodinfoservice.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.friendlyfoods.foodinfoservice.models.Food;

/**
 * @author devia
 * FoodInfo service Microservice - http://localhost:8083/food/101
 * 
 * output-> foodId	"101" name	"Pasta"
 *
 */
@RestController
@RequestMapping("/food")
public class FoodInfoService {

	@RequestMapping("/{foodId}")
	public Food getFoodInfoById(@PathVariable("foodId") String foodId){
		return new Food(foodId,"Pasta"); //replace with data from dao and iterate to find the right food item
	}
	
}
