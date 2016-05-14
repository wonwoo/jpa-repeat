package me.wonwoo.exam9.entity.table;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 5. 14..
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class Item {

  @Id
  @GeneratedValue
  @Column(name = "ITEM_ID")
  private Long id;

  private String name;

  private int price;

}
