package me.wonwoo.exam10;

import me.wonwoo.exam10.model.Member;
import me.wonwoo.exam10.model.Team;

import javax.persistence.*;

import java.util.List;

import static java.util.stream.Collectors.*;

/**
 * Created by wonwoo on 2016. 4. 24..
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
    //객체를 탐색하는 것이다.
    TypedQuery<Member> query =
      entityManager.createQuery("select m from Member m", Member.class);
    System.out.println(
      query.getResultList()
        .stream()
      .map(i -> i.toString())
      .collect(joining("\n"))
    );

    TypedQuery<Member> memberQuery =
      entityManager.createQuery("select m from Member m inner join m.team t where t.id = 1", Member.class);
    String str = memberQuery.getResultList()
      .stream()
      .map(i -> i.toString())
      .collect(joining("\n"));
    System.out.println(str);
  }

  private static void saveTeam(EntityManager entityManager) {
    Member member = new Member();
    member.setName("wonwoo");
    member.setEmail("test@test.com");

    Member member1 = new Member();
    member1.setName("wonwoo2");
    member1.setEmail("test2@test.com");

    Team team = new Team();
    team.setName("team1");

    entityManager.persist(team);
  }

  private static void save(EntityManager entityManager) {

    Team team = new Team();
    team.setName("team1");
    Team team1 = new Team();
    team1.setName("team2");

    Member member = new Member();
    member.setName("wonwoo");
    member.setEmail("test@test.com");
    member.setTeam(team);

    Member member1 = new Member();
    member1.setName("wonwoo2");
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
