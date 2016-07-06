package me.wonwoo.exam14.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 7. 6..
 */
@Entity
@Data
public class Comment {

  @Id @GeneratedValue
  private Long id;

  private String comment;

  @ManyToOne
  @JoinColumn(name = "BOARD_ID")
  private Board board;
}
