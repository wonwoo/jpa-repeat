package me.wonwoo.exam08.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 7. 9..
 */
@Entity
@Data
public class Child {

  @Id @GeneratedValue
  private Long ig;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private Parent parent;
}
