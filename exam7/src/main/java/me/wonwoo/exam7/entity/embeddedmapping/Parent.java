package me.wonwoo.exam7.entity.embeddedmapping;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wonwoo on 2016. 5. 15..
 */
@Entity
@Data
public class Parent {
  @Id
  @Column(name = "PARENT_ID")
  private String id;

  private String name;

}
