package com.devicespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devicespringboot.entity.EquipmentEntity;

public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Long>{

}
