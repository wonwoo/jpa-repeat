package me.wonwoo.exam14.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by wonwoo on 2016. 7. 6..
 */
@Entity
@Data
public class Team {
  @Id
  private String id;

  @OneToMany
  @JoinColumn
  private Collection<Member> members = new ArrayList<Member>();
}
