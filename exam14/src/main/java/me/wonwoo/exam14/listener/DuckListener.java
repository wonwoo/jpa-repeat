package me.wonwoo.exam14.listener;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

/**
 * Created by wonwoo on 2016. 7. 6..
 */
public class DuckListener {

  @PrePersist
  public void perPersist(Object obj){
    System.out.println("DuckListener.perPersist obj=" + obj);
  }

  @PostPersist
  public void postPersist(Object obj){
    System.out.println("DuckListener.postPersist obj=" + obj);
  }
}
