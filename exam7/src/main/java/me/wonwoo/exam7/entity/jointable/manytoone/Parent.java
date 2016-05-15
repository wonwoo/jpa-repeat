//package me.wonwoo.exam7.entity.jointable.manytoone;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
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
//  @OneToMany(mappedBy = "parent")
//  private List<Child> child = new ArrayList<>();
//}
