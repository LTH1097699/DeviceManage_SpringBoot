package com.devicespringboot.conveter;

import java.util.List;

public interface IGeneralConverter<D,E> {
	E toEntity(D d);
	D toDTO(E e);
	List<E> toListEntity(List<D> ds);
	List<D> toListDTO(List<E> es);
	E toOldEntity(D d, E oldE);
	
}
