package me.wonwoo.exam9.entity.join;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 5. 14..
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
@Data
public abstract class Item {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private int price;

}
