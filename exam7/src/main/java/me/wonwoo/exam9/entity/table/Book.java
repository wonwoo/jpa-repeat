package me.wonwoo.exam9.entity.table;

import lombok.Data;
import me.wonwoo.exam9.entity.join.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by wonwoo on 2016. 5. 14..
 */
@Entity
@Data
public class Book extends Item {

  private String author;
  private String isbn;
}
