package hcmute.service;

import java.util.Optional;

import hcmute.entity.MilkTeaEntity;

public interface IMilkTeaService {
	// Find a product by id
	Optional<MilkTeaEntity> findByIdMilkTea(int id);
}
