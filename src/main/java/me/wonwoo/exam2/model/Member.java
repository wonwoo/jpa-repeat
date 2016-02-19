package me.wonwoo.exam2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by wonwoo on 2016. 2. 20..
 */
@Entity
@Table(name = "MEMBER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String username;

    private Integer age;
}
