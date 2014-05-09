package com.pcxa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pcxa.dao.BaseDao;
import com.pcxa.model.Goods;
import com.pcxa.model.GoodsClassification;
import com.pcxa.service.GoodsService;

@Service 
@Transactional
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private BaseDao<Goods> goodsDao ;
	@Autowired
	private BaseDao<GoodsClassification> goodsClassificationDao ;
	
	@Override
	public Integer insert(Goods goods) {
		return (Integer) goodsDao.save(goods);
	}

	@Override
	public Goods get(Integer id) {
		return goodsDao.get(Goods.class,id) ;
	}

	@Override
	public void update(Goods goods) {
		goodsDao.update(goods) ;
	}

	@Override
	public List<Goods> findGoodsByShopId(int shopId) {
		return goodsDao.find("FROM Goods g WHERE g.shop.shopId=?", new Object[]{shopId}) ;
	}

	@Override
	public GoodsClassification getClassification(Integer id) {
		return goodsClassificationDao.get(GoodsClassification.class, id);
	}

	@Override
	public List<GoodsClassification> getAllClassification() {
		return goodsClassificationDao.find("FROM GoodsClassification");
	}
}
