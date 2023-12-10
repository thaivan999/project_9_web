package hcmute.service;

import java.util.Optional;

public interface IBranchMilkTeaService {

	Optional<Integer> findRemainQuantityByBranchIdAndMilkTeaId(int idBranch, int idMilkTea, String size);
}
