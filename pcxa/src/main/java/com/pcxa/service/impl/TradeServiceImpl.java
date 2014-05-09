package com.pcxa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcxa.dao.BaseDao;
import com.pcxa.model.Trade;
import com.pcxa.model.TradeClassification;
import com.pcxa.service.TradeService;

@Service
public class TradeServiceImpl implements TradeService {
	
	@Autowired
	private BaseDao<Trade> tradeDao ;
	@Autowired
	private BaseDao<TradeClassification> tradeClassificationDao ;
	
	@Override
	public Trade get(Integer id) {
		return tradeDao.get(Trade.class, id);
	}

	@Override
	public Integer insert(Trade trade) {
		return (Integer) tradeDao.save(trade);
	}

	@Override
	public void update(Trade trade) {
		tradeDao.update(trade) ;
	}

	@Override
	public void delete(Trade trade) {
		tradeDao.delete(trade) ;
	}

	@Override
	public List<Trade> findAllTrade() {
		return tradeDao.find("FROM Trade t ORDER BY t.tradeId DESC");
	}

	@Override
	public TradeClassification getTradeClassification(Integer id) {
		return tradeClassificationDao.get(TradeClassification.class, id);
	}

	@Override
	public List<TradeClassification> findAllTradeClassification() {
		return tradeClassificationDao.find("FROM TradeClassification");
	}

}
