package com.green.nowon.domain.entity.goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsImgRepository extends JpaRepository<GoodsImgEntity, Long>{

}
