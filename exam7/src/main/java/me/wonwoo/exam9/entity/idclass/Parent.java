package me.wonwoo.exam9.entity.idclass;

import lombok.Data;
import me.wonwoo.exam9.entity.embedded.ParentId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by wonwoo on 2016. 5. 14..
 */

@Entity
@Data
@IdClass(ParentId.class)
public class Parent {

  @Id
  @Column(name = "PARENT_ID1")
  private String id1;

  @Id
  @Column(name = "PARENT_ID2")
  private String id2;

  private String name;
}
