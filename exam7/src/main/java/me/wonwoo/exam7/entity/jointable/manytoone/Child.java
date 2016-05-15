//package me.wonwoo.exam7.entity.jointable.manytoone;
//
//import lombok.Data;
//
//import javax.persistence.*;
//
///**
// * Created by wonwoo on 2016. 5. 15..
// */
//@Entity
//@Data
//public class Child {
//
//  @Id
//  @GeneratedValue
//  @Column(name = "CHILD_ID")
//  private Long id;
//
//  private String name;
//
//  @ManyToOne(optional = false)
//  @JoinTable(name = "PARENT_CHILD",
//    joinColumns = @JoinColumn(name = "CHILD_ID"),
//    inverseJoinColumns = @JoinColumn(name = "PARENT_ID"))
//  private Parent parent;
//}
