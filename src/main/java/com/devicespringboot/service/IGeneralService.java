package com.devicespringboot.service;

import java.util.List;

public interface IGeneralService<T> {
	List<T> findAll();
	T save(T t);
	void delete(Long id);
	T findOneById(Long id);
}
