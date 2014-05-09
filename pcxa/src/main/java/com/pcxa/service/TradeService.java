package com.pcxa.service;

import java.util.List;

import com.pcxa.model.Trade;
import com.pcxa.model.TradeClassification;

public interface TradeService {

	public Trade get(Integer id) ;
	public Integer insert(Trade trade) ;
	public void update(Trade trade) ;
	public void delete(Trade trade) ;
	public List<Trade> findAllTrade() ;
	public TradeClassification getTradeClassification(Integer id) ;
	public List<TradeClassification> findAllTradeClassification() ;
	
}
