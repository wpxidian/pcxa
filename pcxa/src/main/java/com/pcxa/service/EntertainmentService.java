package com.pcxa.service;

import java.util.List;

import com.pcxa.model.Entertainment;
import com.pcxa.model.EntertainmentClassification;

public interface EntertainmentService {

	public List<Entertainment> findAllEntertainment() ;
	public Integer insert(Entertainment entertainment) ;
	public void delete(Entertainment entertainment) ;
	public Entertainment get(Integer id) ;
	public void update(Entertainment entertainment) ;
	public EntertainmentClassification getClassification(Integer id) ;
	public List<EntertainmentClassification> getAllClassification() ;
}
