package pl.simplecrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.simplecrud.dao.UserDAO;
import pl.simplecrud.dao.UserDAO;
import pl.simplecrud.entity.User;

@Service
public class UserService implements GenericService<User> {

	@Autowired
	private UserDAO userDao;

	@Override
	@Transactional
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	@Transactional
	public User getOne(int id) {
		return userDao.getOne(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		userDao.delete(id);
	}

}
