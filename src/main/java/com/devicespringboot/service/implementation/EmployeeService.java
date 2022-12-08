package com.devicespringboot.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devicespringboot.conveter.implementation.EmployeeConverter;
import com.devicespringboot.dto.EmployeeDTO;
import com.devicespringboot.entity.EmployeeEntity;
import com.devicespringboot.repository.EmployeeRepository;
import com.devicespringboot.service.IAccountListener;
import com.devicespringboot.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeConverter employeeConverter;
	
	@Autowired
	private IAccountListener accountListener;

	@Override
	public List<EmployeeDTO> findAll() {
		return employeeConverter.toListDTO(employeeRepository.findAll());
	}

	public List<EmployeeDTO> findAll(Pageable pageable) {
		List<EmployeeDTO> ds = findAll();
		if (ds.isEmpty())
			return new ArrayList<>();

		int start = pageable.getPageNumber();
		int end = start * pageable.getPageSize();

		if (end > ds.size())
			end = ds.size();
		
		return new PageImpl<>(ds.subList(start, end), pageable, ds.size()).getContent();
	}

	@Override
	public EmployeeDTO save(EmployeeDTO t) {
		if(t.getId()!=null) {
			EmployeeEntity oldE = employeeRepository.getOne(t.getId());
			
			return employeeConverter.toDTO(
					employeeRepository.save(employeeConverter.toOldEntity(t, oldE)));
		}
		EmployeeEntity e = employeeRepository.save(employeeConverter.toEntity(t));
		return accountListener.createAccountForEmployee(e);
	}

	@Override
	public void delete(Long id) {
		employeeRepository.deleteById(id);
		accountListener.deleteAccountForEmployee(id);
	}

	@Override
	public EmployeeDTO findOneById(Long id) {
		return employeeConverter.toDTO(employeeRepository.getOne(id));
	}

	@Override
	public boolean existsById(Long id) {
		return employeeRepository.existsById(id);
	}

	@Override
	public Page<EmployeeDTO> findAllPage(Pageable pageable) {
		return employeeConverter.toPagesDTO(
				employeeRepository.findAll(pageable));
	}

}
