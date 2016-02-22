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
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    //다 대 일 (요눔이 연관관걔 주인이 된듯하다.)
    //ManyToOne 에는 mappedBy 속성이 없다. OneToMany는 연관관계의 주인이 될수 없다
    //왜냐하면 RDB 특성상이다. 다대일 관계에서는 항상 다 쪽이 외래키가 있다.
//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
//    private Team team;
//
//    public void setTeam(Team team) {
//        this.team = team;
//        if (!team.getMembers().contains(this)) {
//            team.getMembers().add(this);
//        }
//
//    }



    /////////////////////////

    //연관관계 주인을 정해야된다.
    //Member 테이블에 외래키를 가지고 있으므로 연관관계 주인이다.
//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;

//    @OneToOne(mappedBy = "member")
//    private Locker locker;


    //하지만 실무에서 쓰긴 한계가 있다.
//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT", joinColumns = @JoinColumn(name = "MEMBER_ID"),
//            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
//    private List<Product> products = new ArrayList<>();
//
//
//    @OneToMany(mappedBy = "member")
//    private List<MemberProduct> memberProducts;

    @OneToMany(mappedBy = "member")
    private  List<Order> orders = new ArrayList<>();

}
