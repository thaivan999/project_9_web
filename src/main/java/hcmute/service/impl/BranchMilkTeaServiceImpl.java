package hcmute.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.repository.BranchMilkTeaRepository;
import hcmute.service.IBranchMilkTeaService;

@Service
public class BranchMilkTeaServiceImpl implements IBranchMilkTeaService{
	@Autowired
	BranchMilkTeaRepository branchMilkTeaRepository;

	public BranchMilkTeaServiceImpl(BranchMilkTeaRepository branchMilkTeaRepository) {
		this.branchMilkTeaRepository = branchMilkTeaRepository;
	}
	
	@Override
	public Optional<Integer> findRemainQuantityByBranchIdAndMilkTeaId(int idBranch, int idMilkTea) {
		return branchMilkTeaRepository.findRemainQuantityByBranchIdAndMilkTeaId(idBranch, idMilkTea);
	}
	
}
