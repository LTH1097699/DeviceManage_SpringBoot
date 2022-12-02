package com.devicespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devicespringboot.entity.EquipmentEntity;


@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Long>{

}
