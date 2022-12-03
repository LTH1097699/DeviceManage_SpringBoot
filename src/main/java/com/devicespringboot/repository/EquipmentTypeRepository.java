package com.devicespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devicespringboot.entity.EquipmentTypeEntity;

public interface EquipmentTypeRepository extends JpaRepository<EquipmentTypeEntity, Long> {

}
