package com.pcxa.service;

import java.util.List;

import com.pcxa.model.TouristClassification;
import com.pcxa.model.TouristSpot;

public interface TouristSpotService {
	
	public TouristSpot get(Integer id) ;
	public Integer insert(TouristSpot touristSpot) ;
	public void update(TouristSpot touristSpot) ;
	public void delete(TouristSpot touristSpot) ;
	public List<TouristSpot> findAllTouristSpot() ;
	public TouristClassification getTouristClassification(Integer id) ;
	public List<TouristClassification> findAllTouristClassification() ;
}
