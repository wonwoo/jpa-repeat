package me.wonwoo.exam14;

import me.wonwoo.exam14.model.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Comment;

/**
 * Created by wonwoo on 2016. 7. 6..
 */
public class JpaMain {

  static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");

  public static void main(String[] args) {
    //엔티티 매니저 생성 (비용이 많이 안든다.)
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    //트랜잭션 획득
    EntityTransaction transaction = entityManager.getTransaction();

    try {
      transaction.begin(); // 트랜잭션 시작


      Team team = new Team();
      team.setId("test");
      System.out.println(team.getMembers().getClass());
      entityManager.persist(team);
      System.out.println(team.getMembers().getClass());


//      List<Comment> commentList = new ArrayList<Comment>();
//      boolean result = commentList.add(data);
//
//      commentList.contains(comment);
//      commentList.remove(comment);

//      Set<Comment> commentList = new HashSet<Comment>();
//      boolean result = commentList.add(data);
//
//      commentList.contains(comment);
//      commentList.remove(comment);

      transaction.commit();
    } catch (Exception e) {
      System.out.println(e);
      transaction.rollback();
    } finally {
      entityManager.close();
    }

    entityManagerFactory.close();
  }


}
