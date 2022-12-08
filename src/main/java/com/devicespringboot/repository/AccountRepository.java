package com.devicespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devicespringboot.entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
	@Query(value="SELECT * FROM emp_account e WHERE e.email= :email", nativeQuery = true)
	AccountEntity findByEmail(String email);
	
	@Query(value="SELECT * FROM emp_account e WHERE e.emp_id= :emp_id", nativeQuery = true)
	AccountEntity findByEmployeeId(Long emp_id);

}
