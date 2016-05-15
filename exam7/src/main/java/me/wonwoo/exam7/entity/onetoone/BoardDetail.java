package me.wonwoo.exam7.entity.onetoone;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 5. 15..
 */
@Entity
@Data
public class BoardDetail {

  @Id
  private Long boardId;

  @MapsId
  @OneToOne
  @JoinColumn(name = "BOARD_ID")
  private Board board;

  private String content;
}
