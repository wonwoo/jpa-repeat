package me.wonwoo.exam7.entity.noembeddedmapping;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 5. 15..
 */
@Entity
@Data
public class Child {

  @Id
  @GeneratedValue
  @Column(name = "CHILD_ID")
  private Long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "PARENT_ID")
  private Parent parent;
}
