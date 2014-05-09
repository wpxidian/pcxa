package com.pcxa.service;

import java.util.List;

import com.pcxa.model.Food;

public interface FoodService {
	public List<Food> findAllFood() ;
	public Integer insert(Food food) ;
	public void delete(Food food) ;
	public Food get(Integer id) ;
	public void update(Food food) ;
}
