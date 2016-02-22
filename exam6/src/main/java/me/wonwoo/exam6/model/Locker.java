package me.wonwoo.exam6.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 2. 22..
 */
@Entity
@Data
public class Locker {
    @Id
    @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

//    @OneToOne(mappedBy = "locker")
//    private Member member;

    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
}
