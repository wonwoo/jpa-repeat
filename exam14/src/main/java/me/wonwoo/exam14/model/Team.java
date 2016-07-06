package me.wonwoo.exam14.model;

import lombok.Data;
import me.wonwoo.exam14.converter.BooleanToYNConverter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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

//  @OneToMany(mappedBy = "team")
//  @OrderBy("username desc, id asc")
//  private Set<Member> members = new HashSet<Member>();
}
