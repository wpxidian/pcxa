package com.pcxa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pcxa.dao.BaseDao;
import com.pcxa.model.User;
import com.pcxa.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private BaseDao<User> userDao ;

	@Override
	public User get(Integer id) {
		return userDao.get(User.class,id) ;
	}

}
