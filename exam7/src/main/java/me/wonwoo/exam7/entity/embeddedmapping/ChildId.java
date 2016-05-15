package me.wonwoo.exam7.entity.embeddedmapping;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by wonwoo on 2016. 5. 15..
 */
@Data
@Embeddable
public class ChildId implements Serializable {

  private String parentId; //@MapsId("parentId") 로 매핑
  private String childId;
}

