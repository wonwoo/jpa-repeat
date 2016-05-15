package me.wonwoo.exam7.entity.idmapping;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by wonwoo on 2016. 5. 15..
 */
@Data
public class GrandChildId implements Serializable{
  private ChildId child;
  private String id;
}
