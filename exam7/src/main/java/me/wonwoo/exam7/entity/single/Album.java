package me.wonwoo.exam7.entity.single;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by wonwoo on 2016. 5. 14..
 */
@Entity
@DiscriminatorValue("A")
@Data
public class Album extends Item {
  private String artist;
}
