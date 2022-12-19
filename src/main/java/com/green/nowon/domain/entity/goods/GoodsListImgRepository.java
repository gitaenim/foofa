package com.green.nowon.domain.entity.goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsListImgRepository extends JpaRepository<GoodsListImg, Long> {

}
