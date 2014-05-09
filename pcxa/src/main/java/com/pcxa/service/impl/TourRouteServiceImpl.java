package com.pcxa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pcxa.dao.BaseDao;
import com.pcxa.model.TourRoute;
import com.pcxa.model.TourRouteClassification;
import com.pcxa.service.TourRouteService;

@Service
@Transactional
public class TourRouteServiceImpl implements TourRouteService {
	@Autowired
	private BaseDao<TourRoute> TourRouteDao ;
	@Autowired
	private BaseDao<TourRouteClassification> tourRouteClassificationDao ;
	
	@Override
	public TourRoute get(Integer id) {
		return TourRouteDao.get(TourRoute.class,id);
	}

	@Override
	public Integer insert(TourRoute tourRoute) {
		return (Integer) TourRouteDao.save(tourRoute);
	}

	@Override
	public void update(TourRoute tourRoute) {
		TourRouteDao.update(tourRoute);
	}

	@Override
	public void delete(TourRoute tourRoute) {
		TourRouteDao.delete(tourRoute);
	}

	@Override
	public List<TourRoute> findAllTourRoute() {
		return TourRouteDao.find("FROM TourRoute t ORDER BY t.tourRouteId DESC");
	}

	@Override
	public List<TourRouteClassification> findAllTourRouteClassification() {
		return tourRouteClassificationDao.find("FROM TourRouteClassification");
	}
	@Override
	public TourRouteClassification getTourRouteClassification(Integer id) {
		return tourRouteClassificationDao.get(TourRouteClassification.class,id);
	}

}
