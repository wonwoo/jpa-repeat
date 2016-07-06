package me.wonwoo.exam14.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wonwoo on 2016. 7. 6..
 */
@Entity
@Data
public class Member {

  @Id
  private String id;

  private String name;

}
