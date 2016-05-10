package me.wonwoo.exam08;

import me.wonwoo.exam08.model.Member;
import me.wonwoo.exam08.model.Team;

import javax.persistence.*;

/**
 * Created by wonwoo on 2016. 5. 10..
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
      printUserAndTeam(entityManager);
      printUser(entityManager);
      proxy(entityManager);
      proxyInit(entityManager);
      transaction.commit();
    } catch (Exception e) {
      System.out.println(e);
      transaction.rollback();
    } finally {
      entityManager.close();
    }
    entityManagerFactory.close();
  }

  private static void proxyInit(EntityManager entityManager) {
    entityManager.flush();
    entityManager.clear();
    Member findMember = entityManager.getReference(Member.class, 3L);
    System.out.println("프록시 초기화 전");
    System.out.println(entityManager.getEntityManagerFactory().getPersistenceUnitUtil().isLoaded(findMember));
    System.out.println("findMember = " + findMember.getClass());
    System.out.println(findMember.getName()); //프록시 초기화
    System.out.println("프록시 초기화 후");
    System.out.println(entityManager.getEntityManagerFactory().getPersistenceUnitUtil().isLoaded(findMember));
//  entityManagerFactory.getPersistenceUnitUtil().isLoaded();
  }

  private static void proxy2(EntityManager entityManager) {
    Member member = entityManager.find(Member.class, 3L);
    Team team = entityManager.getReference(Team.class, "team1");
    member.setTeam(team);
  }

  private static void proxy1(EntityManager entityManager) {
    Team team = entityManager.getReference(Team.class, "team1");
    System.out.println(team.getId());

  }

  private static void proxy(EntityManager entityManager) {
    Member member = entityManager.getReference(Member.class, 3L);
    System.out.println(member.getName());
  }

  private static void printUser(EntityManager entityManager) {
    Member member = entityManager.find(Member.class, 3L);
    System.out.println("회원명 : " + member.getName());
  }

  private static void printUserAndTeam(EntityManager entityManager) {

    Member member = entityManager.find(Member.class, 3L);
    Team team = member.getTeam();
    System.out.println("회원명 : " + member.getName());
    System.out.println("소속팀 : " + team.getName());
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
