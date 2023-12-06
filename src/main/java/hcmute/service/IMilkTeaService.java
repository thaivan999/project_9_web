package hcmute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import hcmute.entity.MilkTeaEntity;


public interface IMilkTeaService {
	List<MilkTeaEntity> findAllByTypeId(Integer typeId);
	Optional<MilkTeaEntity> findByIdMilkTea(int id);
	List<MilkTeaEntity> findAll();
	
	List<MilkTeaEntity> findRelevantProducts(@Param("typeId") int typeId, @Param("milkTeaId") int milkTeaId);
	List<MilkTeaEntity> findFourProductsOutstanding();
	List<MilkTeaEntity>findFiveProduct(); 
	List<MilkTeaEntity> findFiveProductOutstanding();
	List<MilkTeaEntity> findByNameContaining(String name);
	List<MilkTeaEntity> findByNameContainingAndSortAscendingByCost(String name);
	List<MilkTeaEntity> findByNameContainingAndSortDescendingByCost(String name);
}
