package com.green.nowon.domain.entity.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemEntityRepository extends JpaRepository<CartItemEntity, Long>{

	Optional<CartItemEntity> findByCnoAndGno(long cno, long itemNo);
	
	List<CartItemEntity> findByCnoMno(String email);
}
