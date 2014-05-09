package com.pcxa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pcxa.dao.BaseDao;
import com.pcxa.model.Hotel;
import com.pcxa.service.HotelService;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {
	@Autowired
	private BaseDao<Hotel> hotelDao ;
	
	@Override
	public List<Hotel> findAllHotel() {
		return hotelDao.find("FROM Hotel h ORDER BY h.hotelId DESC");
	}

	@Override
	public Integer insert(Hotel hotel) {
		return (Integer) hotelDao.save(hotel);
	}

	@Override
	public void delete(Hotel hotel) {
		hotelDao.delete(hotel) ;
	}

	@Override
	public Hotel get(Integer id) {
		return hotelDao.get(Hotel.class,id);
	}

	@Override
	public void update(Hotel hotel) {
		hotelDao.update(hotel) ;
	}

}
