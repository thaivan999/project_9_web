package hcmute.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.entity.MilkTeaEntity;
import hcmute.repository.MilkTeaRepository;
import hcmute.service.IMilkTeaService;

@Service
public class MilkTeaServiceImpl implements IMilkTeaService {
	@Autowired
	MilkTeaRepository milkTeaRepository;

	public MilkTeaServiceImpl(MilkTeaRepository milkTeaRepository) {
		this.milkTeaRepository = milkTeaRepository;
	}
	
	@Override
	public Optional<MilkTeaEntity> findByIdMilkTea(int id) {
		return milkTeaRepository.findByIdMilkTea(id);
	}
}
