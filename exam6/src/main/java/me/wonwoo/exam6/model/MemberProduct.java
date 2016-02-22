package me.wonwoo.exam6.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 2. 22..
 */
@Entity
@IdClass(MemberProductId.class)
@Data
public class MemberProduct {

    @Id
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;  //MemberProductId.member 연결

    @Id
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private int orderAmount;

}
