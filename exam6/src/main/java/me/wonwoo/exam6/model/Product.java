package me.wonwoo.exam6.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wonwoo on 2016. 2. 22..
 */
@Entity
@Data
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    private String id;

    private String name;

//    @ManyToMany(mappedBy = "products")
//    private List<Member> members;

}
