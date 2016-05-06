package me.wonwoo.exam10.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 4. 24..
 */
@Entity
@Data
public class Member {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String email;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TEAM_ID")
  private Team team;


  //연관관계 메소드
  public void setTeam(Team team){
    if(this.team != null){
      this.team.getMembers().remove(this);
    }
    this.team = team;
    team.getMembers().add(this);
  }

}
