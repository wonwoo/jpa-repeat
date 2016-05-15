package me.wonwoo.exam7.entity.idmapping;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 5. 15..
 */
@Entity
@Data
@IdClass(ChildId.class)
public class Child {
  @Id
  @ManyToOne
  @JoinColumn(name = "PARENT_ID")
  private Parent parent;

  @Id
  @Column(name = "CHILD_ID")
  private String childId;

  private String name;
}
