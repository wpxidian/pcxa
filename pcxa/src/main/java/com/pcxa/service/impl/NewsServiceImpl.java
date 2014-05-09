package com.pcxa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pcxa.dao.BaseDao;
import com.pcxa.model.News;
import com.pcxa.service.NewsService;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private BaseDao<News> newsDao ;
	
	@Override
	public List<News> findAllNews() {
		return newsDao.find("FROM News n ORDER BY n.newsId DESC");
	}

	@Override
	public boolean insert(News news) {
		return (Boolean) newsDao.save(news);
	}

	@Override
	public News get(Integer id) {
		return newsDao.get(News.class,id) ;
	}

	@Override
	public void update(News news) {
		newsDao.update(news) ;
	}

	@Override
	public void delete(News news) {
		newsDao.delete(news) ;
	}
}
