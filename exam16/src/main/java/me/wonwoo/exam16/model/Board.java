package me.wonwoo.exam16.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Created by wonwoo on 2016. 7. 4..
 */
@Entity
@Data
public class Board {

  @Id
  private Long id;

  private String title;

  @Version
  private Integer version;
}
