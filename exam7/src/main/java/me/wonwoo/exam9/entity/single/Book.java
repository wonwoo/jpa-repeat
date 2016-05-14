package me.wonwoo.exam9.entity.single;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by wonwoo on 2016. 5. 14..
 */
@Entity
@Data
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "BOOK_ID")
public class Book extends Item {

  private String author;
  private String isbn;
}
