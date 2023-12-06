package hcmute.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import hcmute.entity.MilkTeaTypeEntity;

public interface IMilkTeaTypeService {

	Page<MilkTeaTypeEntity> findByidTypeContaining(int idType, Pageable pageable);

	Page<MilkTeaTypeEntity> findAll(Pageable pageable);

	long count();
	
	List<MilkTeaTypeEntity> findAllByCategoryId(int categoryId);

}
