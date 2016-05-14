package me.wonwoo.exam9.entity.idclass;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by wonwoo on 2016. 5. 14..
 */
@Data
public class ParentId implements Serializable{

  private String id1;

  private String id2;
}
