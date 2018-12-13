package pl.simplecrud.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.cj.api.mysqla.result.Resultset.Type;

public abstract class AbstractDAO<T> {

	@Autowired
	public SessionFactory sessionFactory;

	protected Class<T> entityClass;

	public AbstractDAO() {
		ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
		entityClass = (Class<T>) pt.getActualTypeArguments()[0];
	}

	public T getOne(int id) {
		Session session = sessionFactory.getCurrentSession();
		T t = session.get(entityClass, id);
		return t;
	}

	public List<T> getAll() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<T> query = session.createQuery("from " + entityClass.getSimpleName(), entityClass);
		List<T> t = query.getResultList();
		return t;
	}

	public T save(T t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
		return t;
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		T t = getOne(id);
		session.delete(t);
	}
}
