package me.wonwoo.exam08;

import me.wonwoo.exam08.model.Child;
import me.wonwoo.exam08.model.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by wonwoo on 2016. 7. 9..
 */
public class JpaMain1 {

  static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");

  public static void main(String[] args) {
    //엔티티 매니저 생성 (비용이 많이 안든다.)
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    //트랜잭션 획득
    EntityTransaction transaction = entityManager.getTransaction();
    try {
      transaction.begin(); // 트랜잭션 시작
//      saveNoCascade(entityManager);
//      saveWithCascade(entityManager);
//      deleteNoCascade(entityManager);
//      deleteWithCascade(entityManager);
      deleteOrphan(entityManager);
      transaction.commit();
    } catch (Exception e) {
      System.out.println(e);
      transaction.rollback();
    } finally {

      entityManager.close();
    }
    entityManagerFactory.close();
  }

  private static void deleteOrphan(EntityManager entityManager){
    Parent parent = entityManager.find(Parent.class, 1L);
    parent.getChildren().remove(0);
  }

  private static void deleteNoCascade(EntityManager entityManager){
    Parent parent = entityManager.find(Parent.class, 1L);
    Child child1 = entityManager.find(Child.class, 2L);
    Child child2 = entityManager.find(Child.class, 3L);

    entityManager.remove(child1);
    entityManager.remove(child2);
    entityManager.remove(parent);
  }

  private static void deleteWithCascade(EntityManager entityManager){
    Parent parent = entityManager.find(Parent.class, 1L);
    entityManager.remove(parent);
  }

  private static void saveNoCascade(EntityManager entityManager){
    Parent parent = new Parent();
    entityManager.persist(parent);

    Child child1 = new Child();
    child1.setParent(parent);
    entityManager.persist(child1);

    Child child2 = new Child();
    child2.setParent(parent);
    entityManager.persist(child2);
  }
  private static void saveWithCascade(EntityManager entityManager){
    Child child1 = new Child();
    Child child2 = new Child();

    Parent parent = new Parent();
    child1.setParent(parent);
    child2.setParent(parent);

    parent.getChildren().add(child1);
    parent.getChildren().add(child2);

    entityManager.persist(parent);
  }
}
