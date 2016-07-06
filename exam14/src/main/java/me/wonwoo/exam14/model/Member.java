package me.wonwoo.exam14.model;

import lombok.Data;
import me.wonwoo.exam14.converter.BooleanToYNConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wonwoo on 2016. 7. 6..
 */
@Entity
@Data
@Convert(converter = BooleanToYNConverter.class, attributeName = "vip")
public class Member {

  @Id
  private String id;

  private String name;

//  @Convert(converter = BooleanToYNConverter.class)
  private boolean vip;
}
