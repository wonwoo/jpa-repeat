package me.wonwoo.exam4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wonwoo on 2016. 2. 20..
 */

/**
 * 이런 기능들은 단지 DDL을 자동으로 생성할 때만 사용하고 JPA 실행 로직에는 영향을 주지 않는다.
 * 아이텐티티전략 및 시퀀스전략은 디비가 바뀔때마다 수정해야 된다
 * AUTO 전략의 장점은 데이터베이스를 변경해도 코드를 수정할 필요가 없다는거 특히 키 생성 전략이 아직 확정되지 않은 개발 초기 단계나 프로토타입 개발시 편리하게 사용한다.
 */

@Entity
@Table(name = "MEMBER", uniqueConstraints = {@UniqueConstraint(
        name = "NAME_AGE_UNIQUE",
        columnNames = {"NAME", "AGE"}
)})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member4 {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME", nullable = false, length = 10)
    private String username;

    private Integer age;


    //자바의 enum타입과 매핑 한다.
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    //날짜 타입을 매핑한다.
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;
}
