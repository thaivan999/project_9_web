package hcmute.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.query.Param;

import hcmute.entity.MilkTeaEntity;

public interface IMilkTeaService {
	Page<MilkTeaEntity> findAll(Pageable pageable);

	long count();

	Page<MilkTeaEntity> findByNameContaining(@Param("name") String name, Pageable pageable);

	List<MilkTeaEntity> findFourProductsOutstanding();

	List<MilkTeaEntity> findAllByTypeId(int typeId);

	Optional<MilkTeaEntity> findByIdMilkTea(int id);

	List<MilkTeaEntity> findRelevantProducts(@Param("typeId") int typeId, @Param("milkTeaId") int milkTeaId);

	List<MilkTeaEntity> findFiveProduct();

	List<MilkTeaEntity> findFiveProductOutstanding();

	List<MilkTeaEntity> findByNameContainingAndSortAscendingByCost(String name);

	List<MilkTeaEntity> findByNameContainingAndSortDescendingByCost(String name);

	List<MilkTeaEntity> findAll();

	void sortByOrderDetailQuantity(List<MilkTeaEntity> milkTeaList);

	int countByTypeId(int typeId);

	int countByNameContaining(@Param("name") String name);

	Page<MilkTeaEntity> findAllByTypeId(int idType, Pageable pageable);

	<S extends MilkTeaEntity> S save(S entity);

}
