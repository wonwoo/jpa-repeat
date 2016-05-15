package me.wonwoo.exam7.entity.embeddedmapping;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by wonwoo on 2016. 5. 15..
 */
@Data
@Embeddable
public class GrandChildId implements Serializable{
  private ChildId childId; //@MapsId("childId") 로 매핑

  @Column(name = "GRANDCHILD_ID")
  private String id;
}
