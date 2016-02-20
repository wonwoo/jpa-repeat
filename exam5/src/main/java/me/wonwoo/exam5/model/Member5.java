package me.wonwoo.exam5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 2. 20..
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member5 {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    private String username;

    public Member5(String id, String username){
        this.id = id;
        this.username = username;
    }


    //연관관계의 주인
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public void setTeam(Team team){
        //기존 연관관계 제거
        if(this.team != null){
            this.team.getMembers().remove(this);
        }
        this.team = team;
        team.getMembers().add(this);
    }
}
