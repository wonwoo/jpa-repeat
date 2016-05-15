package me.wonwoo.exam7.entity.onetoone;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 5. 15..
 */
@Entity
@Data
public class Board {

  @Id
  @GeneratedValue
  @Column(name = "BOARD_ID")
  private Long id;

  private String title;

  @OneToOne(mappedBy = "board")
  private BoardDetail boardDetail;

}
