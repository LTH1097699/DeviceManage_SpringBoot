package com.devicespringboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGeneralService<T> {
	List<T> findAll();
	Page<T> findAllPage(Pageable pageable);
	T save(T t);
	void delete(Long id);
	T findOneById(Long id);
	boolean existsById(Long id);
}
