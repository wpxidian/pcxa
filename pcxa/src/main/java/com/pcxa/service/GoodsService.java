package com.pcxa.service;

import java.util.List;

import com.pcxa.model.Goods;
import com.pcxa.model.GoodsClassification;

public interface GoodsService {
	
	public List<Goods> findGoodsByShopId(int shopId) ;
	public Integer insert(Goods goods) ;
	public Goods get(Integer id) ; 
	public void update(Goods goods) ;
	public GoodsClassification getClassification(Integer id) ;
	public List<GoodsClassification> getAllClassification() ;
}
