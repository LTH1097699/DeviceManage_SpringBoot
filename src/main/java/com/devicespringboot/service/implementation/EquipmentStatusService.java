package com.devicespringboot.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devicespringboot.conveter.implementation.EquipmentStatusConverter;
import com.devicespringboot.dto.EquipmentStatusDTO;
import com.devicespringboot.repository.EquipmentStatusRepository;
import com.devicespringboot.service.IGeneralService;



@Service
public class EquipmentStatusService implements IGeneralService<EquipmentStatusDTO> {

	@Autowired
	private EquipmentStatusConverter equipmentStatusConverter;

	@Autowired
	private EquipmentStatusRepository equipmentStatusRepository;

	@Override
	public List<EquipmentStatusDTO> findAll() {
		return equipmentStatusConverter.toListDTO(equipmentStatusRepository.findAll());
	}

	public List<EquipmentStatusDTO> findAll(Pageable pageable) {
		List<EquipmentStatusDTO> ds = findAll();
		if (ds == null)
			return new ArrayList<>();

		int start = pageable.getPageNumber();
		int end = start * pageable.getPageSize();

		if (end > ds.size())
			end = ds.size();

		return new PageImpl<>(ds.subList(start, end), pageable, ds.size()).getContent();
	}

	@Override
	public EquipmentStatusDTO save(EquipmentStatusDTO t) {
		if (t.getId() != null) {

		}
		return null;
	}

	@Override
	public void delete(Long id) {
		equipmentStatusRepository.deleteById(id);

	}

	@Override
	public EquipmentStatusDTO findOneById(Long id) {
		return equipmentStatusConverter.toDTO(equipmentStatusRepository.getOne(id));
	}
	
	@Override
	public boolean existsById(Long id) {
		return equipmentStatusRepository.existsById(id);
	}
}
