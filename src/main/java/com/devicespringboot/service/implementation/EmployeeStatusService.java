package com.devicespringboot.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devicespringboot.conveter.implementation.EmployeeStatusConverter;
import com.devicespringboot.dto.EmployeeStatusDTO;
import com.devicespringboot.repository.EmployeeStatusRepository;
import com.devicespringboot.service.IGeneralService;



@Service
public class EmployeeStatusService implements IGeneralService<EmployeeStatusDTO> {
	@Autowired
	private EmployeeStatusRepository employeeStatusRepository;

	@Autowired
	private EmployeeStatusConverter employeeStatusConverter;

	@Override
	public List<EmployeeStatusDTO> findAll() {
		return employeeStatusConverter.toListDTO(employeeStatusRepository.findAll());
	}

	public List<EmployeeStatusDTO> findAll(Pageable pageable) {
		List<EmployeeStatusDTO> ds = findAll();
		if (ds.size() == 0)
			return new ArrayList<>();

		int start = pageable.getPageNumber();
		int end = start * pageable.getPageSize();

		if (end > ds.size())
			end = ds.size();

		return new PageImpl<>(ds.subList(start, end), pageable, ds.size()).getContent();
	}

	@Override
	public EmployeeStatusDTO save(EmployeeStatusDTO t) {
		if (t.getId() != null) {

		}
		return null;
	}

	@Override
	public void delete(Long id) {
		employeeStatusRepository.deleteById(id);
	}

	@Override
	public EmployeeStatusDTO findOneById(Long id) {
		return employeeStatusConverter.toDTO(employeeStatusRepository.getOne(id));
	}
	
	@Override
	public boolean existsById(Long id) {
		return employeeStatusRepository.existsById(id);
	}
}
