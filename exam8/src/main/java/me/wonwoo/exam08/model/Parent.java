package me.wonwoo.exam08.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wonwoo on 2016. 7. 9..
 */
@Entity
@Data
public class Parent {

  @Id @GeneratedValue
  private Long id;

  @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
  private List<Child> children = new ArrayList<>();
}
