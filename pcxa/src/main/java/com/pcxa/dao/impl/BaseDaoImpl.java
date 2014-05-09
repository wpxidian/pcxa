package com.pcxa.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.pcxa.dao.BaseDao;
/**
 * 
 * 类名称：BaseDaoImpl   
 * 类描述：通过泛型实现通用的DAO   
 * 创建人：WangPeng  
 * 创建时间：2014-4-30 上午11:20:48   
 * 修改人：WangPeng   
 * 修改时间：2014-4-30 上午11:20:48   
 * 修改备注：   
 * @version 1.0   
 *
 */
@Repository("baseDao")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	@Resource 
	public void setSuperSessionFactory(SessionFactory sessionFactory) {  
        super.setSessionFactory(sessionFactory);  
    }

	@Override
	public Serializable save(T o) {
		return getHibernateTemplate().save(o) ;
	}

	@Override
	public void delete(T o) {
		getHibernateTemplate().delete(o) ;
	}

	@Override
	public void update(T o) {
		getHibernateTemplate().update(o) ;
	}

	@Override
	public void saveOrUpdate(T o) {
		getHibernateTemplate().saveOrUpdate(o) ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql) {
		return getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql, Object[] param) {
		Query q = getSessionFactory().openSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}
	
	@Override
	public T get(Class<T> c, Serializable id) {
		return  getHibernateTemplate().get(c, id);
	}

	@Override
	public Long count(String hql) {
		return null;
	}
	
}
