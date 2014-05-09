package com.pcxa.service;

import java.util.List;

import com.pcxa.model.GoodsClassification;

public interface GoodsClassificationService {
	
	public GoodsClassification get(Integer id) ;
	public List<GoodsClassification> getAllClassification() ;
	
}
