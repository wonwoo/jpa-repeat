package me.wonwoo.exam7.entity.embeddedmapping;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 5. 15..
 */
@Entity
@Data
public class Child {

  @EmbeddedId
  private ChildId id;

  @MapsId("parentId") //ChildId.parentId 매핑
  @ManyToOne
  @JoinColumn(name = "PARENT_ID")
  private Parent parent;

  private String name;
}
