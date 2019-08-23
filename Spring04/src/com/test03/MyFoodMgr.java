package com.test03;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyFoodMgr {

	@Autowired
	private Food favoriteFood;
	@Autowired
	private Food unFavoriteFood;

	public MyFoodMgr() {
		favoriteFood = new Food();
		favoriteFood.setName("고기");
		favoriteFood.setPrice(15000);
	}
	
	public MyFoodMgr(Food favoriteFood, Food unFavoriteFood) {
		this.favoriteFood = favoriteFood;
		this.unFavoriteFood = unFavoriteFood;
	}

	public Food getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public Food getUnFavoriteFood() {
		return unFavoriteFood;
	}

	public void setUnFavoriteFood(Food unFavoriteFood) {
		this.unFavoriteFood = unFavoriteFood;
	}

	@Override
	public String toString() {
		return "내가 좋아하는 음식 : " + favoriteFood + "/ 내가 싫어하는 음식 : " + unFavoriteFood;
	}

}
