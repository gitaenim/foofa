package com.green.nowon.domain.entity.delivery;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryEntityRepository extends JpaRepository<DeliveryEntity, Long>{

	long countByMemberEmail(String email);

	Optional<DeliveryEntity> findByBaseAndMemberEmail(boolean base, String email);

}
