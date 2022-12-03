package com.devicespringboot.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devicespringboot.conveter.implementation.EquipmentTypeConverter;
import com.devicespringboot.dto.EquipmentTypeDTO;
import com.devicespringboot.entity.EquipmentTypeEntity;
import com.devicespringboot.repository.EquipmentTypeRepository;
import com.devicespringboot.service.IGeneralService;


@Service
public class EquipmentTypeService implements IGeneralService<EquipmentTypeDTO> {

	@Autowired
	private EquipmentTypeRepository equipmentTypeRepository;

	@Autowired
	private EquipmentTypeConverter equipmentTypeConverter;

	@Override
	public List<EquipmentTypeDTO> findAll() {
		return equipmentTypeConverter.toListDTO(equipmentTypeRepository.findAll());
	}

	public List<EquipmentTypeDTO> findAll(Pageable pageable) {
		List<EquipmentTypeDTO> ds = findAll();
		if (ds.isEmpty())
			return new ArrayList<>();

		int start = pageable.getPageNumber()*pageable.getPageSize();
		int end = start + pageable.getPageSize();

		if (end > ds.size())
			end = ds.size();

		return new PageImpl<>(ds.subList(start, end), pageable, ds.size()).getContent();
	}
	
	@Transactional
	@Override
	public EquipmentTypeDTO save(EquipmentTypeDTO t) {
		if(t.getId() != null) {
			EquipmentTypeEntity oldE = equipmentTypeConverter.toOldEntity(t, equipmentTypeRepository.getOne(t.getId()));
			return equipmentTypeConverter.toDTO(
					equipmentTypeRepository.save(oldE));
		}
		return equipmentTypeConverter.toDTO(
				equipmentTypeRepository.save(equipmentTypeConverter.toEntity(t)));
	}
	
	@Transactional
	@Override
	public void delete(Long id) {
		equipmentTypeRepository.deleteById(id);
	}

	@Override
	public EquipmentTypeDTO findOneById(Long id) {
		return equipmentTypeConverter.toDTO(
					equipmentTypeRepository.getOne(id));
	}
	
	@Override
	public boolean existsById(Long id) {
		return equipmentTypeRepository.existsById(id);
	}
}
