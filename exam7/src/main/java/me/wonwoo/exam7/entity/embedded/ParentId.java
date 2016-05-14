package me.wonwoo.exam7.entity.embedded;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by wonwoo on 2016. 5. 14..
 */
@Data
@Embeddable
public class ParentId implements Serializable {

  @Column(name = "PARENT_ID1")
  private String id1;

  @Column(name = "PARENT_ID2")
  private String id2;
}
