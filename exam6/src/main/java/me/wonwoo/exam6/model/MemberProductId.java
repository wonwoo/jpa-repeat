package me.wonwoo.exam6.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by wonwoo on 2016. 2. 22..
 */

@Data
public class MemberProductId implements Serializable {

    private Long member;  //MemberProduct.member
    private String product;  //MemberProduct.product

}
