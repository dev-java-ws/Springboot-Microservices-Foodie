package io.friendlyfoods.foodcatalogservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.friendlyfoods.foodcatalogservice.models.Food;
import io.friendlyfoods.foodcatalogservice.models.FoodCatalogItem;
import io.friendlyfoods.foodcatalogservice.models.UserRating;

/**
 * @author devia
 * 
 * call FoodRatingService  					foodId:101 rating;4    http://localhost:8084/rating/101
 * for each food id call FoodInfoService    foodId:101 name:pasta  http://localhost:8083/food/101
 * put them all together in the catalog       					   http://localhost:8082/catalog/101
	
 */
@RestController
@RequestMapping("/catalog")
public class FoodCatalogService {

	@Autowired 
	private RestTemplate restTemplate;

	public FoodCatalogService() {
	}
	
	@RequestMapping("/{userId}")
	public List<FoodCatalogItem> getCatalogFoodItemsById(@PathVariable("userId") String userId) {
		UserRating ratings = restTemplate.getForObject("http://rating-data-service/rating/users/"+userId,UserRating.class);//1234 4
				
		return ratings.getRatings().stream().map(rating -> {
			Food food = restTemplate.getForObject("http://food-info-service/food/" + rating.getFoodId(), Food.class);
			return new FoodCatalogItem(food.getName(), "FoodDescription", rating.getRating());//new FoodCatalogItem("Pasta", "Delicious pasta", 4))
		} )
		.collect(Collectors.toList());
	}
}