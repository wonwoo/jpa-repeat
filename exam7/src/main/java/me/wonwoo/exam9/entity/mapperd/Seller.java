package me.wonwoo.exam9.entity.mapperd;

import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by wonwoo on 2016. 5. 14..
 */
@Entity
@Data
public class Seller extends BaseEntity {

  //ID, NAME 상속
  private String shopName;
}
