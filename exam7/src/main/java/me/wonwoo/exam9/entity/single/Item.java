package me.wonwoo.exam9.entity.single;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 5. 14..
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Data
public abstract class Item {

  @Id
  @GeneratedValue
  @Column(name = "ITEM_ID")
  private Long id;

  private String name;

  private int price;

}
