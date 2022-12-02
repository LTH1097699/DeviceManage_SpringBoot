package com.devicespringboot.dto;

import java.util.List;

public class AbstractDTO<T> {
	private Long id;
	
	private List<T> dtoList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<T> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<T> dtoList) {
		this.dtoList = dtoList;
	}
	
	

}
