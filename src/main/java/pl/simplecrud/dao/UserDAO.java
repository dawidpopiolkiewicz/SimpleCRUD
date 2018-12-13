package pl.simplecrud.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.simplecrud.entity.User;

@Repository
public class UserDAO extends AbstractDAO<User> {

	@Autowired
	private SessionFactory sessionFactory;

	public List<User> getAll() {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<User> query = session.createQuery("from " + entityClass.getSimpleName(), entityClass);
		List<User> userList = query.getResultList();
		return userList;
	}

	public User save(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user);
		return user;
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = getOne(id);
		session.delete(user);
	}
}
