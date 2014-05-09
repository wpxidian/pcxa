package com.pcxa.service;

import com.pcxa.model.Shop;

public interface ShopService {
	
	public boolean validUser(String username, String password) ;
	public boolean update(Shop shop) ;

}
