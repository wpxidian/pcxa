package com.pcxa.dao;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * 类名称：BaseDao   
 * 类描述：   
 * 创建人：WangPeng  
 * 创建时间：2014-4-30 上午11:22:37   
 * 修改人：WangPeng   
 * 修改时间：2014-4-30 上午11:22:37   
 * 修改备注：   
 * @version 1.0   
 *
 */
public interface BaseDao<T> {

	public Serializable save(T o);

	public void delete(T o);

	public void update(T o);

	public void saveOrUpdate(T o);

	public List<T> find(String hql);
		
	public List<T> find(String hql, Object[] param);

	/**
	 * @param page
	 *            which pag to display
	 * @param rows
	 *            how many records in each page
	 */

	public T get(Class<T> c, Serializable id);

	public Long count(String hql);

}

