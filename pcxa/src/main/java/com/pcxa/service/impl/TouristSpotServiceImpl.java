package com.pcxa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pcxa.dao.BaseDao;
import com.pcxa.model.TouristClassification;
import com.pcxa.model.TouristSpot;
import com.pcxa.service.TouristSpotService;
@Service
@Transactional
public class TouristSpotServiceImpl implements TouristSpotService {
	
	@Autowired
	private BaseDao<TouristSpot> touristSpotDao ;
	@Autowired
	private BaseDao<TouristClassification> touristClassificationDao ;
	
	@Override
	public List<TouristSpot> findAllTouristSpot() {
		return touristSpotDao.find("FROM TouristSpot t ORDER BY t.touristSpotId DESC");
	}
	@Override
	public TouristSpot get(Integer id) {
		return touristSpotDao.get(TouristSpot.class,id);
	}
	@Override
	public Integer insert(TouristSpot touristSpot) {
		return (Integer) touristSpotDao.save(touristSpot);
	}
	@Override
	public void update(TouristSpot touristSpot) {
		touristSpotDao.update(touristSpot) ;
	}
	@Override
	public void delete(TouristSpot touristSpot) {
		touristSpotDao.delete(touristSpot) ;
	}
	@Override
	public TouristClassification getTouristClassification(Integer id) {
		return touristClassificationDao.get(TouristClassification.class, id);
	}
	@Override
	public List<TouristClassification> findAllTouristClassification() {
		return touristClassificationDao.find("FROM TouristClassification") ;
	}

}
