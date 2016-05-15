package me.wonwoo.exam7.entity.idmapping;

import lombok.Data;
import me.wonwoo.exam7.entity.embeddedmapping.Child;
import me.wonwoo.exam7.entity.embeddedmapping.GrandChildId;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 5. 15..
 */

@Entity
@Data
@IdClass(GrandChildId.class)
public class CrandChild {
  @Id
  @ManyToOne
  @JoinColumns({
    @JoinColumn(name = "PARENT_ID"),
    @JoinColumn(name = "CHILD_ID"),
  })
  private Child child;

  @Id
  @Column(name = "GRANDCHILD_ID")
  private String id;

  private String name;
}
