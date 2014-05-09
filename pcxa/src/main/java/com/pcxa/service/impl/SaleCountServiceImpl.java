/*package com.pcxa.service.impl;

import com.pcxa.dao.SaleCountDao;
import com.pcxa.service.SaleCountService;

public class SaleCountServiceImpl implements SaleCountService {
	
	private SaleCountDao saleCountDaoImpl ;
	
	@Override
	public int getDateYear(int year, int month, int index) {
		if(month+index>=1){
			return year;
		}else{
			return (year-1);
		}
	}

	@Override
	public int getDateMonth(int year, int month, int index) {
		if(month+index>=1){
			return month+index;
		}else{
			return month+index+12;
		}
	}

	@Override
	public String getDateString(int year, int month, int index) {
		if(month+index>=1){
			return year+"年"+(month+index)+"月";
		}else{
			return (year-1)+"年"+(month+index+12)+"月";
		}
	}

	@Override
	public double getSaleMoneyByGoodsIdAndYear(int goodsId, int year) {
		return saleCountDaoImpl.getSaleMoneyByGoodsIdAndYear(goodsId, year);
	}
/
	@Override
	public long getSaleCountByGoodsIdAndYear(int goodsId, int year) {
		return saleCountDaoImpl.getSaleCountByGoodsIdAndYear(goodsId, year) ;
	}

	@Override
	public double getSaleMoneyByGoodsIdAndMonth(int goodsId, int year, int month) {
		return saleCountDaoImpl.getSaleMoneyByGoodsIdAndMonth(goodsId, year, month);
	}

	@Override
	public long getSaleCountByGoodsIdAndMonth(int goodsId, int year, int month) {
		return saleCountDaoImpl.getSaleCountByGoodsIdAndMonth(goodsId, year, month) ;
	}

	@Override
	public double getSaleMoneyByShopIdAndYear(int shopId, int year) {
		return saleCountDaoImpl.getSaleMoneyByShopIdAndYear(shopId, year);
	}

	@Override
	public long getSaleCountByShopIdAndYear(int shopId, int year) {
		return saleCountDaoImpl.getSaleCountByShopIdAndYear(shopId, year) ;
	}

	@Override
	public double getSaleMoneyByShopIdAndMonth(int goodsId, int year, int month) {
		return saleCountDaoImpl.getSaleMoneyByShopIdAndMonth(goodsId, year, month);
	}

	@Override
	public long getSaleCountByShopIdAndMonth(int goodsId, int year, int month) {
		return saleCountDaoImpl.getSaleCountByShopIdAndMonth(goodsId, year, month) ;
	}

}
*/