package com.devicespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devicespringboot.entity.EquipmentStatusEntity;



@Repository
public interface EquipmentStatusRepository extends JpaRepository<EquipmentStatusEntity, Long> {

}
