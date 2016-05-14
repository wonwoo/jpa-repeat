package me.wonwoo.exam7;

import me.wonwoo.exam7.entity.embedded.Parent;
import me.wonwoo.exam7.entity.embedded.ParentId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by wonwoo on 2016. 5. 14..
 */
public class JpaMain2 {
  static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");

  public static void main(String[] args) {
    //엔티티 매니저 생성 (비용이 많이 안든다.)
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    //트랜잭션 획득
    EntityTransaction transaction = entityManager.getTransaction();

    try {
      transaction.begin(); // 트랜잭션 시작
      save(entityManager);
      find(entityManager);
      transaction.commit();
    } catch (Exception e) {
      System.out.println(e);
      transaction.rollback();
    } finally {
      entityManager.close();
    }

    entityManagerFactory.close();
  }

  private static void find(EntityManager entityManager) {
    ParentId parentId = new ParentId();
    parentId.setId1("id1");
    parentId.setId2("id2");
    Parent parent = entityManager.find(Parent.class, parentId);
    System.out.println(parent);
  }

  public static void save(EntityManager entityManager) {
    Parent parent = new Parent();
    ParentId parentId = new ParentId();
    parentId.setId1("id1");
    parentId.setId2("id2");
    parent.setId(parentId);
    parent.setName("wonwoo");
    entityManager.persist(parent);
  }
}
