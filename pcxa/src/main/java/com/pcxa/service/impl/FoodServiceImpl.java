package com.pcxa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcxa.dao.BaseDao;
import com.pcxa.model.Food;
import com.pcxa.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	private BaseDao<Food> foodDao ;
	
	@Override
	public List<Food> findAllFood() {
		return foodDao.find("FROM Food f ORDER BY f.foodId DESC");
	}

	@Override
	public Integer insert(Food food) {
		return (Integer) foodDao.save(food);
	}

	@Override
	public void delete(Food food) {
		foodDao.delete(food);
	}

	@Override
	public Food get(Integer id) {
		return foodDao.get(Food.class,id);
	}

	@Override
	public void update(Food food) {
		foodDao.update(food);
	}

}
