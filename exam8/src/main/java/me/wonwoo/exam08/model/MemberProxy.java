package me.wonwoo.exam08.model;

/**
 * Created by wonwoo on 2016. 5. 10..
 */
public class MemberProxy extends Member{
  Member target = null;
  public String getName(){
    if(target == null){

      // 초기화 요청
      // DB 조회
      // 실제 엔티티 생성 및 참조 보관
//      this.target = ...;
    }
    return target.getName();
  }
}
