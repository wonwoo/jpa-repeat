package me.wonwoo.exam7.entity.table;

import lombok.Data;
import javax.persistence.Entity;

/**
 * Created by wonwoo on 2016. 5. 14..
 */
@Entity
@Data
public class Album extends Item {
  private String artist;
}
