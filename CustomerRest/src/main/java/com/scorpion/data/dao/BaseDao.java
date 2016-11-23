/**
 * 
 */
package com.scorpion.data.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 * @author Linh
 *
 */
@SuppressWarnings("unchecked")
@Repository
public class BaseDao<T> {
	private Class<T> type;
	@Autowired
	private SessionFactory sessionFactory;

	
	
	public BaseDao() {
		//this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	public BaseDao(Class<T> type) {
		this.type = type;
	}

	public Class<T> getPersistentClass() {
		return type;
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public T save(T obj) {
		try {
			getCurrentSession().save(obj);
		} catch (DataAccessException e) {
			System.out.println("save entity error" + e);
		}
		return obj;
	}

	public T saveOrUpdate(T obj) {
		getCurrentSession().saveOrUpdate(obj);
		return obj;
	}

	public void delete(T obj) {
		try {
			getCurrentSession().delete(obj);
		} catch (DataAccessException e) {
			System.out.println("Delete entity error" + e);
		}

	}

	public void deleteById(Integer id) {
		delete(getById(id));
	}

	public T getById(Integer id) {
		return (T) getCurrentSession().get(getPersistentClass(), id);

	}

	public List<T> getBy(String name, String value) {
		Criterion[] cr = new Criterion[1];
		cr[0] = Restrictions.eq(name, value);
		List<T> list = findByCriteria(cr);
		if (list.isEmpty())
			return null;
		return list;
	}

	public List<T> getAll() {
		Criteria crit = getCurrentSession().createCriteria(getPersistentClass());
		List<T> list = crit.list();
		return list;
	}

	public List<T> getWithSQL(String sql) {
		List<T> list = getCurrentSession().createQuery(sql).list();
		return list;
	}

	public List<T> findByCriteria(Criterion... criterion) {

		Criteria crit = getCurrentSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		List<T> list = crit.list();
		return list;
	}
}