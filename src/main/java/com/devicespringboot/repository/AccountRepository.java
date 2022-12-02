package com.devicespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devicespringboot.entity.AccountEntity;



@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
	AccountEntity findByEmail(String email);

}
