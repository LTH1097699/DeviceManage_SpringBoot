package com.devicespringboot.conveter.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.devicespringboot.conveter.IGeneralConverter;
import com.devicespringboot.dto.AccountDTO;
import com.devicespringboot.entity.AccountEntity;
import com.devicespringboot.repository.RoleRepository;

@Component
public class AccountConverter implements IGeneralConverter<AccountDTO, AccountEntity> {
	
	@Autowired
	private RoleConverter roleConverter;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public AccountEntity toEntity(AccountDTO d) {
		AccountEntity e = new AccountEntity();
		e.setEmail(d.getEmail());
		e.setPassword(null);
		e.setPhone(d.getPhone());
		e.setRole(roleRepository.findByRoleCode(d.getRole().getRoleCode()));
		return e;
	}

	@Override
	public AccountDTO toDTO(AccountEntity e) {
		AccountDTO d = new AccountDTO();
		d.setEmail(e.getEmail());
		d.setPassword(null);
		d.setPhone(e.getPhone());
		d.setRole(roleConverter.toDTO(e.getRole()));
		return d;
	}

	@Override
	public List<AccountEntity> toListEntity(List<AccountDTO> ds) {
		List<AccountEntity> es = new ArrayList<>();
		for(AccountDTO d : ds) {
			es.add(toEntity(d));
		}
		return es;
	}

	@Override
	public List<AccountDTO> toListDTO(List<AccountEntity> es) {
		List<AccountDTO> ds = new ArrayList<>();
		for(AccountEntity e : es) {
			ds.add(toDTO(e));
		}
		return ds;
	}

	@Override
	public AccountEntity toOldEntity(AccountDTO d, AccountEntity oldE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AccountDTO> toPagesDTO(Page<AccountEntity> pageE) {		
		return pageE.map(t -> toDTO(t));
	}

}
