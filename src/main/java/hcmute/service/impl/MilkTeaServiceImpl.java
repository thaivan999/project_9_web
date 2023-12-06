package hcmute.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
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
	public List<MilkTeaEntity> findAllByTypeId(Integer typeId) {
		return milkTeaRepository.findAllByTypeId(typeId);
	}

	@Override
	public Optional<MilkTeaEntity> findByIdMilkTea(int id) {
		return milkTeaRepository.findByIdMilkTea(id);
	}

	@Override
	public List<MilkTeaEntity> findAll() {
		return milkTeaRepository.findAll();
	}

	@Override
	public List<MilkTeaEntity> findRelevantProducts(int typeId, int milkTeaId) {
		return milkTeaRepository.findRelevantProducts(typeId, milkTeaId);
	}
	
	@Override
	public List<MilkTeaEntity> findFiveProduct() {
		List<MilkTeaEntity> temp = milkTeaRepository.findAll();
		List<MilkTeaEntity> list = new ArrayList<>();
		if (temp.size() >= 5) {
		    list.addAll(temp.subList(0, 5));
		} else {
		    list.addAll(temp);
		}
		return list;
	}

	@Override
	public List<MilkTeaEntity> findFiveProductOutstanding() {
		return milkTeaRepository.findFiveProductOutstanding();
	}

	@Override
	public List<MilkTeaEntity> findFourProductsOutstanding() {
		return null;
	}

	@Override
	public List<MilkTeaEntity> findByNameContaining(String name) {
		return milkTeaRepository.findByNameContaining(name);
	}

	@Override
	public List<MilkTeaEntity> findByNameContainingAndSortAscendingByCost(String name) {
		return milkTeaRepository.findByNameContainingAndSortAscendingByCost(name);
	}

	@Override
	public List<MilkTeaEntity> findByNameContainingAndSortDescendingByCost(String name) {
		return milkTeaRepository.findByNameContainingAndSortDescendingByCost(name);
	}
	
	
}
