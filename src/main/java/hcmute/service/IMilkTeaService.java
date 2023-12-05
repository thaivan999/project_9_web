package hcmute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import hcmute.entity.MilkTeaEntity;


public interface IMilkTeaService {
	List<MilkTeaEntity> findAllByTypeId(Integer typeId);
	Optional<MilkTeaEntity> findByIdMilkTea(int id);
	List<MilkTeaEntity> findFourProductsOutstanding();
	List<MilkTeaEntity> findAll();
	List<MilkTeaEntity>findFiveProduct(); 
	List<MilkTeaEntity> findFiveProductOutstanding();
}
