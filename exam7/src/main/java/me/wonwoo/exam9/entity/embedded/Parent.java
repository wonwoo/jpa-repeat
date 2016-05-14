package me.wonwoo.exam9.entity.embedded;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created by wonwoo on 2016. 5. 14..
 */
@Entity
@Data
public class Parent {

  @EmbeddedId
  private ParentId id;

  private String name;

}
