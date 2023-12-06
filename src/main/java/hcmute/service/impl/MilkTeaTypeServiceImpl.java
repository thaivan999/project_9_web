package hcmute.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hcmute.entity.MilkTeaCategoryEntity;
import hcmute.entity.MilkTeaTypeEntity;
import hcmute.repository.MilkTeaTypeRepository;
import hcmute.service.IMilkTeaTypeService;

@Service
public class MilkTeaTypeServiceImpl implements IMilkTeaTypeService{
	@Autowired
	MilkTeaTypeRepository milkTeaTypeRepository;

	@Override
	public long count() {
		return milkTeaTypeRepository.count();
	}

	@Override
	public Page<MilkTeaTypeEntity> findAll(Pageable pageable) {
		return milkTeaTypeRepository.findAll(pageable);
	}

	@Override
	public Page<MilkTeaTypeEntity> findByidTypeContaining(int idType, Pageable pageable) {
		return milkTeaTypeRepository.findByidTypeContaining(idType, pageable);
	}

	@Override
	public List<MilkTeaTypeEntity> findAllByCategoryId(int categoryId) {
		return milkTeaTypeRepository.findAllByCategoryId(categoryId);
	}
	
}
