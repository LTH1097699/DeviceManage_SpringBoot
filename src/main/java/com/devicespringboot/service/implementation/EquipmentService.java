package com.devicespringboot.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devicespringboot.conveter.implementation.EquipmentConverter;
import com.devicespringboot.dto.EquipmentDTO;
import com.devicespringboot.entity.EquipmentEntity;
import com.devicespringboot.repository.EquipmentRepository;
import com.devicespringboot.service.IEquipmentService;

@Service
public class EquipmentService implements IEquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepository;

	@Autowired
	private EquipmentConverter equipmentConverter;

	@Override
	public List<EquipmentDTO> findAll() {
		return equipmentConverter.toListDTO(equipmentRepository.findAll());
	}
	@Override
	public List<EquipmentDTO> findAll(Pageable pageable) {
		List<EquipmentDTO> ds = findAll();
		if (ds.isEmpty())
			return new ArrayList<>();

		int start = pageable.getPageNumber();
		int end = start * pageable.getPageSize();

		if (end > ds.size())
			end = ds.size();

		return new PageImpl<>(ds.subList(start, end), pageable, ds.size()).getContent();
	}


	@Override
	public void delete(Long id) {
		equipmentRepository.deleteById(id);
	}

	@Override
	public EquipmentDTO save(EquipmentDTO t) {
		if (t.getId() != null) {
			EquipmentEntity oldE = equipmentRepository.getOne(t.getId());
			return equipmentConverter.toDTO(
					equipmentRepository.save(equipmentConverter.toOldEntity(t, oldE)));
		}
		return equipmentConverter.toDTO(
				equipmentRepository.save(equipmentConverter.toEntity(t)));
	}

	@Override
	public EquipmentDTO findOneById(Long id) {
		return equipmentConverter.toDTO(equipmentRepository.getOne(id));
	}
	
	@Override
	public boolean existsById(Long id) {
		return equipmentRepository.existsById(id);
	}
	@Override
	public Page<EquipmentDTO> findAllPage(Pageable pageable) {
		return equipmentConverter.toPagesDTO(
				equipmentRepository.findAll(pageable));
	}

}
