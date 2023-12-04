package hcmute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hcmute.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Integer>{
}
