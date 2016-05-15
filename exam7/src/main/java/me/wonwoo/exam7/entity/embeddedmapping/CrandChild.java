package me.wonwoo.exam7.entity.embeddedmapping;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 5. 15..
 */

@Entity
@Data
public class CrandChild {

  @EmbeddedId
  private GrandChildId id;

  @MapsId("childId") // GrandChildId.childId 매핑
  @ManyToOne
  @JoinColumns({
    @JoinColumn(name = "PARENT_ID"),
    @JoinColumn(name = "CHILD_ID"),
  })
  private Child child;

  private String name;
}
