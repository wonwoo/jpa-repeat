//package me.wonwoo.exam7.entity.jointable.onetoone;
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
//public class Parent {
//  @Id
//  @GeneratedValue
//  @Column(name = "PARENT_ID")
//  private Long id;
//
//  private String name;
//
//  @OneToOne
//  @JoinTable(name = "PARENT_CHILD",
//    joinColumns = @JoinColumn(name = "PARENT_ID"),
//    inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))
//  private Child child;
//}
