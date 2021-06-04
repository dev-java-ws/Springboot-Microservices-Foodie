package io.friendlyfoods.ratingsdataservice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.friendlyfoods.ratingsdataservice.models.Rating;
import io.friendlyfoods.ratingsdataservice.models.UserRating;

/*
 * This spring boot microservice application gives a list of food items for the given user
 * http://localhost:8084/rating/101
 * 
 * o/p  - foodId	"101"        rating	4
 */
@RestController
@RequestMapping("/rating")
public class FoodRatingsService {
	
	@RequestMapping("/{foodId}")
	public Rating getFoodRatingById(@PathVariable("foodId") String foodId) {
		return new Rating(foodId,5);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRating getFoodRatingByUserId(@PathVariable("userId") String userId) {
		List<Rating> ratings =  Arrays.asList(new Rating("101",5), new Rating("102",4)); //replace data from dao
		UserRating userRatings = new UserRating();
		userRatings.setRatings(ratings);
		return userRatings;
	}
	

		
}
