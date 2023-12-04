package hcmute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hcmute.entity.CartDetailEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hcmute.embeddedId.CartDetailId;
import hcmute.entity.CartDetailEntity;
import hcmute.entity.MilkTeaEntity;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetailEntity, CartDetailId> {
	List<CartDetailEntity> findByCartByCartDetailIdCart(int idCart);

    @Query("SELECT cd.milkTeaByCartDetail FROM CartDetailEntity cd WHERE cd.cartByCartDetail.idCart = :idCart")
    List<MilkTeaEntity> findMilkTeaByCartId(int idCart);
}
