package me.wonwoo.exam9.entity.mapperd;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by wonwoo on 2016. 5. 14..
 */
@MappedSuperclass
@Data
public abstract class BaseEntity {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
}
