package com.pcxa.service;

import java.util.List;

import com.pcxa.model.Hotel;

public interface HotelService {

	public List<Hotel> findAllHotel() ;
	public Integer insert(Hotel hotel) ;
	public void delete(Hotel hotel) ;
	public Hotel get(Integer id) ;
	public void update(Hotel hotel) ;
	
}
