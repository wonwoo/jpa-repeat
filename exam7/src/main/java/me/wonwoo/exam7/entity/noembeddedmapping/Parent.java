package me.wonwoo.exam7.entity.noembeddedmapping;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wonwoo on 2016. 5. 15..
 */
@Data
@Entity
public class Parent {
  @Id
  @GeneratedValue
  @Column(name = "PARENT_ID")
  private Long id;

  private String name;
}
