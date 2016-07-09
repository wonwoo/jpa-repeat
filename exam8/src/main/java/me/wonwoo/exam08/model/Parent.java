package me.wonwoo.exam08.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wonwoo on 2016. 7. 9..
 */
@Entity
@Data
@ToString(exclude = "children")
public class Parent {

  @Id
  @GeneratedValue
  private Long id;

//  @OneToMany(mappedBy = "parent")
//  private List<Child> children = new ArrayList<>();

  @OneToMany(mappedBy = "parent", orphanRemoval = true)
  private List<Child> children = new ArrayList<>();

//  @OneToMany(mappedBy = "parent" ,cascade = CascadeType.PERSIST)
//  private List<Child> children = new ArrayList<>();

//  @OneToMany(mappedBy = "parent" ,cascade = CascadeType.REMOVE)
//  private List<Child> children = new ArrayList<>();
}
