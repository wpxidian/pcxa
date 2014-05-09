package com.pcxa.service.impl;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pcxa.dao.BaseDao;
import com.pcxa.model.Shop;
import com.pcxa.service.ShopService;

@Service 
@Transactional
public class ShopServiceImpl implements ShopService{
	@Autowired
	private BaseDao<Shop> shopDao ;
	
	/**
	 * 
	 */
	@Override
	public boolean validUser(String username, String password) {
		List<Shop> shopList = shopDao.find("FROM Shop s WHERE s.username=?",new Object[]{username}) ;
		for(Shop shop:shopList){
			if(shop.getPassword().equals(password)){
				ServletActionContext.getRequest().getSession().setAttribute("shop",shop) ;
				return true ;
			}
		}		
		return false ;	
	}
	/**
	 * 
	 */
	@Override
	public boolean update(Shop shop) {
		if(shop == null){
			return false ;
		}else{
			shopDao.update(shop) ;
			return true ;
		}
	}
}
