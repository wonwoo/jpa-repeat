package me.wonwoo.exam6.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wonwoo on 2016. 2. 22..
 */
@Entity
@Data
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    //양뱡향은 서로 참조 해야된다
    //양방향은 외래키가 있는 쪽이 연관관계 주인이다.
    //이로써 양방향
//    @OneToMany(mappedBy = "team")
//    @JoinColumn(name = "TEAM_ID")
//    private List<Member> members = new ArrayList<>();
//
//    public void addMember(Member member){
//        this.members.add(member);
//        if(member.getTeam() != this){
//            member.setTeam(this);
//        }
//    }
}
