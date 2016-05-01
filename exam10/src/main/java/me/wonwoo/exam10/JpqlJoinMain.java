package me.wonwoo.exam10;

import me.wonwoo.exam10.model.Member;
import me.wonwoo.exam10.model.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/**
 * Created by wonwoo on 2016. 5. 1..
 */
public class JpqlJoinMain {
  static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");

  public static void main(String[] args) {
    //엔티티 매니저 생성 (비용이 많이 안든다.)
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    //트랜잭션 획득
    EntityTransaction transaction = entityManager.getTransaction();

    try {
      transaction.begin(); // 트랜잭션 시작
      save(entityManager);
//      innerJoin(entityManager);
//      innerJoinTeam(entityManager);
//      outerJoin(entityManager);
//      collectionJoin(entityManager);
      crossJoin(entityManager);
      transaction.commit();
    } catch (Exception e) {
      System.out.println(e);
      transaction.rollback();
    } finally {
      entityManager.close();
    }

    entityManagerFactory.close();
  }

  private static void crossJoin(EntityManager entityManager) {
String query = "select m from Member m , Team t where t.name = m.name";
List<Member> members = entityManager.createQuery(query,Member.class)
  .getResultList();
System.out.println(
  members.stream().map(i -> i.toString()).collect(joining("\n"))
);
  }

  private static void collectionJoin(EntityManager entityManager) {
    String query = "select t, m from Team t inner join t.members m";
    List<Object[]> objects = entityManager.createQuery(query)
      .getResultList();

    objects.forEach(i -> {
      Team team = (Team) i[0];
      Member member = (Member) i[1];
      System.out.println(team);
      System.out.println(member);
    });
  }

  private static void outerJoin(EntityManager entityManager) {
    String query = "select m from Member m left join m.team t where t.name = :teamName";
    List<Member> members = entityManager.createQuery(query,Member.class)
      .setParameter("teamName", "team1")
      .getResultList();
    System.out.println(
      members.stream().map(i -> i.toString()).collect(joining("\n"))
    );
  }

  private static void innerJoinTeam(EntityManager entityManager) {
    String query = "select m, t from Member m inner join m.team t where t.name = :teamName order by m.name desc";

    List<Object[]> objects = entityManager.createQuery(query)
      .setParameter("teamName","team1")
      .getResultList();

    objects.forEach(i -> {
      Member member = (Member) i[0];
      Team team = (Team) i[1];
      System.out.println(member);
      System.out.println(team);
    });


  }

  private static void innerJoin(EntityManager entityManager) {
    String team = "team1";
    String query = "select m from Member m inner join m.team t where t.name = :teamName";

    List<Member> members = entityManager.createQuery(query,Member.class)
      .setParameter("teamName", team)
      .getResultList();
    System.out.println(
      members.stream().map(i -> i.toString()).collect(joining("\n"))
    );
  }

  

  private static void save(EntityManager entityManager) {

    Team team = new Team();
    team.setName("team1");
    Team team1 = new Team();
    team1.setName("toby");

    Member member = new Member();
    member.setName("wonwoo");
    member.setEmail("test@test.com");
    member.setTeam(team);

    Member member1 = new Member();
    member1.setName("toby");
    member1.setEmail("test2@test.com");
    member1.setTeam(team);

    Member member2 = new Member();
    member2.setName("kevin");
    member2.setEmail("kevin@test.com");
    member2.setTeam(team1);

    entityManager.persist(team);
    entityManager.persist(team1);

    entityManager.persist(member);
    entityManager.persist(member1);
    entityManager.persist(member2);
  }
}
