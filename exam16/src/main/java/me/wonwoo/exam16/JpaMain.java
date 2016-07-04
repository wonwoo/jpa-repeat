package me.wonwoo.exam16;

import me.wonwoo.exam16.model.Board;

import javax.persistence.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by wonwoo on 2016. 7. 4..
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
//      save(entityManager);
      Board board = entityManager.find(Board.class, 1L);
//      Board board = entityManager.find(Board.class, 1L, LockModeType.OPTIMISTIC);

//      TimeUnit.SECONDS.sleep(20);
      board.setTitle("aaa");
      transaction.commit();
    } catch (Exception e) {
      System.out.println(e);
      transaction.rollback();
    } finally {
      entityManager.close();
    }

    entityManagerFactory.close();
  }


  private static void save(EntityManager entityManager) {
    Board board = new Board();
    board.setId(1L);
    board.setTitle("제목1");
    entityManager.persist(board);
  }
}

