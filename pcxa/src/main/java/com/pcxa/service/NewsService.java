package com.pcxa.service;

import java.util.List;

import com.pcxa.model.News;

public interface NewsService {

	public List<News> findAllNews() ;
	public boolean insert(News news) ;
	public void delete(News news) ;
	public News get(Integer id) ;
	public void update(News news) ;
}
