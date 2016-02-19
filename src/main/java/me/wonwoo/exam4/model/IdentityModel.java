package me.wonwoo.exam4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by wonwoo on 2016. 2. 20..
 */

/**
 * identity 전략 기본키를 데이터 베이스에 위임 mysql, postgresql, db2등에서사용
 */
@Entity
public class IdentityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
