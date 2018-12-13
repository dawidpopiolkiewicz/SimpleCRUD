package pl.simplecrud.service;

import java.util.List;

import pl.simplecrud.entity.User;

public interface GenericService<T> {

	List<T> getAll();

	void save(T t);

	User getOne(int id);

	void delete(int id);
}
