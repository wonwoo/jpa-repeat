package me.wonwoo.exam7;

import me.wonwoo.exam7.entity.onetoone.Board;
import me.wonwoo.exam7.entity.onetoone.BoardDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by wonwoo on 2016. 5. 15..
 */
public class JpaMain3 {
  static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");

  public static void main(String[] args) {
    //엔티티 매니저 생성 (비용이 많이 안든다.)
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    //트랜잭션 획득
    EntityTransaction transaction = entityManager.getTransaction();

    try {
      transaction.begin(); // 트랜잭션 시작
      save(entityManager);
      transaction.commit();
    } catch (Exception e) {
      System.out.println(e);
      transaction.rollback();
    } finally {
      entityManager.close();
    }

    entityManagerFactory.close();
  }

  private static void save(EntityManager entityManager){
    Board board = new Board();
    board.setTitle("제목");
    entityManager.persist(board);

    BoardDetail boardDetail = new BoardDetail();
    boardDetail.setContent("내용");
    boardDetail.setBoard(board);
    entityManager.persist(boardDetail);
  }
}
