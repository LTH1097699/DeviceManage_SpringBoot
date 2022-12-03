package com.devicespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devicespringboot.entity.EquipmentStatusEntity;

public interface EquipmentStatusRepository extends JpaRepository<EquipmentStatusEntity, Long> {

}
