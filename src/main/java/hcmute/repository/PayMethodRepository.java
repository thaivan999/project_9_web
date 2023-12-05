package hcmute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hcmute.entity.PayMethodEntity;

public interface PayMethodRepository extends JpaRepository<PayMethodEntity, String>{
	
}
