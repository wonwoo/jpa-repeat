package me.wonwoo.exam7.entity.noembeddedmapping;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 5. 15..
 */
@Data
@Entity
public class GrandChild {

  @Id
  @GeneratedValue
  @Column(name = "GRANDCHILD_ID")
  private Long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "CHILD_ID")
  private Child child;
}
