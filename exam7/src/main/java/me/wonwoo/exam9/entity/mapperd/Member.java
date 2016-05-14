package me.wonwoo.exam9.entity.mapperd;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 5. 14..
 */
@Entity
@Data
@AttributeOverrides({
  @AttributeOverride(name = "id", column = @Column(name = "MEMBER_ID")),
  @AttributeOverride(name = "name", column = @Column(name = "MEMBER_NAME"))
})
public class Member extends BaseEntity {

  //ID, NAME 상속
  private String email;
}
