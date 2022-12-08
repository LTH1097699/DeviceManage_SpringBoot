package com.devicespringboot.service.implementation;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devicespringboot.dto.AccountDTO;
import com.devicespringboot.entity.AccountEntity;
import com.devicespringboot.repository.AccountRepository;
import com.devicespringboot.service.IGeneralService;

@Service
public class AccountService implements IGeneralService<AccountDTO> {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<AccountDTO> findAll() {
		return Collections.emptyList();
	}

	@Override
	public Page<AccountDTO> findAllPage(Pageable pageable) {
		return null;
	}

	@Override
	public AccountDTO save(AccountDTO t) {
		return null;
	}

	@Override
	public void delete(Long id) {
		accountRepository.deleteById(id);
		
	}
	
	public void deleteByEmployeeId(Long id) {
		AccountEntity e= accountRepository.findByEmployeeId(id);
		accountRepository.delete(e);
		
	}

	@Override
	public AccountDTO findOneById(Long id) {
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		return accountRepository.existsById(id);
	}
	
}
