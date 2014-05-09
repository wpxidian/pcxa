package com.pcxa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pcxa.dao.BaseDao;
import com.pcxa.model.Indent;
import com.pcxa.service.IndentService;

@Service 
@Transactional
public class IndentServiceImpl implements IndentService {
	@Autowired
	private BaseDao<Indent> indentDao ;

	@Override
	public List<Indent> findAllIndents() {
		return indentDao.find("FROM Indent i ORDER BY i.indentId DESC");
	}

	@Override
	public List<Indent> findIndentsByTradeCondition(Integer trade_condition) {
		return indentDao.find("FROM Indent i WHERE i.tradeCondition = ? ",new Object[]{trade_condition}) ;
	}

	@Override
	public List<Indent> findIndentsByGoodsId(Integer goodsId) {
		return indentDao.find("FROM Indent i WHERE i.goods.goodsId = ? ",new Object[]{goodsId}) ;
	}

	@Override
	public List<Indent> findIndentsByTradeConAndGoodsId(Integer trade_condition,
			Integer goodsId) {
		return indentDao.find("FROM Indent i WHERE i.goods.goodsId = ? AND i.tradeCondition = ?",new Object[]{goodsId,trade_condition}) ;
	}

	@Override
	public Indent get(Integer id) {
		return indentDao.get(Indent.class,id) ;
	}

	@Override
	public void update(Indent indent) {
		indentDao.update(indent) ;
	}

}
