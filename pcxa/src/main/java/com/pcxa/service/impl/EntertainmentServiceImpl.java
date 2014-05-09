package com.pcxa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcxa.dao.BaseDao;
import com.pcxa.model.Entertainment;
import com.pcxa.model.EntertainmentClassification;
import com.pcxa.service.EntertainmentService;

@Service
public class EntertainmentServiceImpl implements EntertainmentService {
	
	@Autowired
	private BaseDao<Entertainment> entertainmentDao;
	@Autowired
	private BaseDao<EntertainmentClassification> entertainmentClassificationDao ;
	
	@Override
	public List<Entertainment> findAllEntertainment() {
		return entertainmentDao.find("FROM Entertainment e ORDER BY e.entertainmentId DESC");
	}

	@Override
	public Integer insert(Entertainment entertainment) {
		return (Integer) entertainmentDao.save(entertainment);
	}

	@Override
	public void delete(Entertainment entertainment) {
		entertainmentDao.delete(entertainment) ;
	}

	@Override
	public Entertainment get(Integer id) {
		return entertainmentDao.get(Entertainment.class, id);
	}

	@Override
	public void update(Entertainment entertainment) {
		entertainmentDao.update(entertainment) ;
	}

	@Override
	public EntertainmentClassification getClassification(Integer id) {
		return entertainmentClassificationDao.get(EntertainmentClassification.class,id);
	}

	@Override
	public List<EntertainmentClassification> getAllClassification() {
		return entertainmentClassificationDao.find("FROM EntertainmentClassification");
	}

}
