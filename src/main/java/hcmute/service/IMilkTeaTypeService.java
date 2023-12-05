package hcmute.service;

import java.util.List;

import hcmute.entity.MilkTeaTypeEntity;


public interface IMilkTeaTypeService {

	List<MilkTeaTypeEntity> findAllByCategoryId(int categoryId);

}
