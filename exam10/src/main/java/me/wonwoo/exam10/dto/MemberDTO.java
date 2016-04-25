package me.wonwoo.exam10.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wonwoo on 2016. 4. 25..
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
  private String name;
  //다른 타입이라고 가정하자!
  private String email;
}
