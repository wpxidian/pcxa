package com.pcxa.service;

import java.util.List;

import com.pcxa.model.TourRoute;
import com.pcxa.model.TourRouteClassification;

public interface TourRouteService {

	public TourRoute get(Integer id) ;
	public Integer insert(TourRoute tourRoute) ;
	public void update(TourRoute tourRoute) ;
	public void delete(TourRoute tourRoute) ;
	public List<TourRoute> findAllTourRoute() ;
	public TourRouteClassification getTourRouteClassification(Integer id) ;
	public List<TourRouteClassification> findAllTourRouteClassification() ;
}
