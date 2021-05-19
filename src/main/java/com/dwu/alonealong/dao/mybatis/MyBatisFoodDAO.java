package com.dwu.alonealong.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dwu.alonealong.dao.FoodDAO;
import com.dwu.alonealong.dao.mybatis.mapper.FoodMapper;
import com.dwu.alonealong.domain.Food;

@Repository
public class MyBatisFoodDAO implements FoodDAO{
	
	@Autowired
	private FoodMapper foodMapper;
	
	public List<Food> getFoodListByResId(String resId){
		return foodMapper.getFoodListByResId(resId);
	}
	
	public Food getFood(String foodId) {
		return foodMapper.getFood(foodId);
	}
	
	public void insertFood(Food food) {
		foodMapper.insertFood(food);
	}
	public void updateFood(Food food) {
		foodMapper.updateFood(food);
	}
	public void deleteFood(Food food) {
		foodMapper.deleteFood(food);
	}
	
}
