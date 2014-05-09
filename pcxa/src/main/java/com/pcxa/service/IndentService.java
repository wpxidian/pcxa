package com.pcxa.service;

import java.util.List;

import com.pcxa.model.Indent;

public interface IndentService {
	
	public Indent get(Integer id) ;
	public void update(Indent indent) ;
	public List<Indent> findAllIndents() ;
	public List<Indent> findIndentsByTradeCondition(Integer trade_condition) ;
	public List<Indent> findIndentsByGoodsId(Integer goodsId) ;
	public List<Indent> findIndentsByTradeConAndGoodsId(Integer trade_condition, Integer goodsId) ;
	
}
