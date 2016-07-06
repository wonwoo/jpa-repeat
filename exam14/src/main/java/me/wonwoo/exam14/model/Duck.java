package me.wonwoo.exam14.model;

import lombok.Data;
import me.wonwoo.exam14.listener.DuckListener;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 7. 6..
 */
@Entity
@Data
@EntityListeners(DuckListener.class)
public class Duck {

  @Id @GeneratedValue
  private Long id;

  private String name;
//
//  @PrePersist
//  public void prePersist(){
//    System.out.println("Duck.prePersist id=" + id);
//  }
//
//  @PostPersist
//  public void postPersist(){
//    System.out.println("Duck.postPersist id=" + id);
//  }
//  @PostLoad
//  public void postLoad(){
//    System.out.println("Duck.postLoad");
//  }
//
//  @PreRemove
//  public void preRemove(){
//    System.out.println("Duck.preRemove");
//  }
//
//  @PostRemove
//  public void postRemove(){
//    System.out.println("Duck.postRemove");
//  }
}
