package me.wonwoo.exam9.entity.idclass;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 5. 14..
 */
@Entity
@Data
public class Child {

  @Id
  private String id;

  @ManyToOne
  @JoinColumns({
    @JoinColumn(name = "PARENT_ID1",referencedColumnName = "PARENT_ID1"),
    @JoinColumn(name = "PARENT_ID2",referencedColumnName = "PARENT_ID2")
  })
  private Parent parent;
}
