package me.wonwoo.exam7.entity.idmapping;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by wonwoo on 2016. 5. 15..
 */
@Data
public class ChildId implements Serializable {

  private String parent;
  private String childId;
}

