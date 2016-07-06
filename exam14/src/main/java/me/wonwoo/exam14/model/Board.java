package me.wonwoo.exam14.model;

import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wonwoo on 2016. 7. 6..
 */
@Entity
@Data
public class Board {
  @Id @GeneratedValue
  private Long id;

  private String title;

  @OneToMany(mappedBy = "board")
  @OrderColumn(name = "POSITION")
  private List<Comment> comments = new ArrayList<Comment>();
}
