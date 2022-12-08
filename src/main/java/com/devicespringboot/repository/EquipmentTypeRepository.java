package com.devicespringboot.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devicespringboot.entity.EquipmentTypeEntity;

public interface EquipmentTypeRepository extends JpaRepository<EquipmentTypeEntity, Long> {
	public Slice<EquipmentTypeEntity> findBy(Pageable pageable);
	
	EquipmentTypeEntity findOneByCode(String code);
}
