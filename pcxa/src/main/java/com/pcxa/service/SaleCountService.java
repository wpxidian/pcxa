package com.pcxa.service;

public interface SaleCountService {

	public int getDateYear(int year ,int month ,int index) ;
	public int getDateMonth(int year ,int month ,int index) ;
	public String getDateString(int year ,int month ,int index) ;
	
	public double getSaleMoneyByGoodsIdAndYear(int goodsId, int year) ;
	public long getSaleCountByGoodsIdAndYear(int goodsId, int year) ;
	
	public double getSaleMoneyByGoodsIdAndMonth(int goodsId, int year, int month) ;
	public long getSaleCountByGoodsIdAndMonth(int goodsId, int year, int month) ;
	
	public double getSaleMoneyByShopIdAndYear(int shopId, int year) ;
	public long getSaleCountByShopIdAndYear(int shopId, int year) ;
	
	public double getSaleMoneyByShopIdAndMonth(int goodsId, int year, int month) ;
	public long getSaleCountByShopIdAndMonth(int goodsId, int year, int month) ;
	
}
