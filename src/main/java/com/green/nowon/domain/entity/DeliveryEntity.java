package com.green.nowon.domain.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@SequenceGenerator(name = "gen_d",sequenceName = "seq_d",allocationSize = 1,initialValue = 1)
@Table(name = "delivery")
@Entity
public class DeliveryEntity {

}
