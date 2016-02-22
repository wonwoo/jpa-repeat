package me.wonwoo.exam6.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 2. 22..
 */
@Entity
@Data
@SequenceGenerator(
        name = "ORDER_SEQ_GENERATOR",
        sequenceName = "ORDER_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "ORDERINFO")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ORDER_SEQ_GENERATOR")
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private int orderAmount;

}
