package com.devicespringboot.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devicespringboot.conveter.implementation.EmployeeConverter;
import com.devicespringboot.dto.EmployeeDTO;
import com.devicespringboot.entity.EmployeeEntity;
import com.devicespringboot.repository.EmployeeRepository;
import com.devicespringboot.service.IEmployeeListener;
import com.devicespringboot.service.IEmployeeService;



@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeConverter employeeConverter;

	@Autowired
	private List<IEmployeeListener> deletionListeners;
	
	private AccountListener accountListener;

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
		return employeeConverter.toDTO(
				employeeRepository.save(employeeConverter.toEntity(t)));
	}

	@Override
	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public EmployeeDTO findOneById(Long id) {
		return employeeConverter.toDTO(employeeRepository.getOne(id));
	}

	public void delete(Long id, String n) {
		deletionListeners.forEach(listener -> listener.deleteEmployee(id));
	}

	@Override
	public boolean existsById(Long id) {
		return employeeRepository.existsById(id);
	}

	
//	@Override
//	public EmployeeDTO findById(Long id) {
//		Optional<EmployeeEntity> eOpt = employeeRepository.findById(id);
//		return eOpt.isPresent() ? employeeConverter.toDTO(eOpt.get()) : null;
//	}
//
//	@Transactional
//	@Override
//	public Long add(EmployeeDTO employee) {
//		ModelMapper mapper = new ModelMapper();
//		EmployeeEntity entity = mapper.map(employee, EmployeeEntity.class);
//		AccountEntity account = mapper.map(employee.getAccount(), AccountEntity.class);
//		RoleEntity role = roleRepository.findByRoleCode(employee.getAccount().getRole().getRoleCode());
//		account.setRole(role);
//		entity.setAccount(account);
//		return employeeRepository.save(entity).getId();
//	}
//

}
