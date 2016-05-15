package me.wonwoo.exam7.entity.jointable.etc;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 5. 15..
 */
@Entity
@Data
@Table(name = "BOARD")
@SecondaryTable(name = "BOARD_DETAIL",
pkJoinColumns = @PrimaryKeyJoinColumn(name = "BOARD_DETAIL_ID"))
public class Board {

  @Id
  @GeneratedValue
  @Column(name = "BOARD_ID")
  private Long id;

  private String title;

  @Column(table = "BOARD_DETAIL")
  private String content;
}
