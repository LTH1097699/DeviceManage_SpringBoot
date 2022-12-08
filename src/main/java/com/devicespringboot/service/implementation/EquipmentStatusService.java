package com.devicespringboot.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devicespringboot.conveter.implementation.EquipmentStatusConverter;
import com.devicespringboot.dto.EquipmentStatusDTO;
import com.devicespringboot.entity.EquipmentStatusEntity;
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

	@Override
	public EquipmentStatusDTO save(EquipmentStatusDTO t) {
		if (t.getId() != null) {
			EquipmentStatusEntity oldE = equipmentStatusRepository.getOne(t.getId());
			equipmentStatusConverter.toDTO(
					equipmentStatusRepository.save(equipmentStatusConverter.toOldEntity(t, oldE)));
		}
		return equipmentStatusConverter.toDTO(
				equipmentStatusRepository.save(equipmentStatusConverter.toEntity(t)));
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

	@Override
	public Page<EquipmentStatusDTO> findAllPage(Pageable pageable) {
		return equipmentStatusConverter.toPagesDTO(equipmentStatusRepository.findAll(pageable));
	}
}
