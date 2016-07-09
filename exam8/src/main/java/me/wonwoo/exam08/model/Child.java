package me.wonwoo.exam08.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 7. 9..
 */
@Entity
@Data
@ToString(exclude = "parent")
public class Child {

  @Id @GeneratedValue
  private Long ig;

  @ManyToOne
  @JoinColumn
  private Parent parent;
}
