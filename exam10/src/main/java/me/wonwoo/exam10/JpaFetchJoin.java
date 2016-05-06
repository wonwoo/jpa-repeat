package me.wonwoo.exam10;

import me.wonwoo.exam10.model.Member;
import me.wonwoo.exam10.model.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by wonwoo on 2016. 5. 6..
 */
public class JpaFetchJoin {

  static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");

  public static void main(String[] args) {
    //엔티티 매니저 생성 (비용이 많이 안든다.)
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    //트랜잭션 획득
    EntityTransaction transaction = entityManager.getTransaction();

    try {
      transaction.begin(); // 트랜잭션 시작
      save(entityManager);
//      fetchJoin(entityManager);
//      collectionFetchJoin(entityManager);
      collectionFetchJoinDistinct(entityManager);
      transaction.commit();
    } catch (Exception e) {
      System.out.println(e);
      transaction.rollback();
    } finally {
      entityManager.close();
    }

    entityManagerFactory.close();
  }

  private static void fetchJoin(EntityManager entityManager) {
    String jpql = "select m from Member m join fetch m.team";
    List<Member> members = entityManager.createQuery(jpql, Member.class)
      .getResultList();

    for(Member member : members){
      //페치 조인으로 회원과 팀을 함께 조회해서 지연로딩 발생안함
      System.out.println("username = " + member.getName() + ", teamname = " + member.getTeam().getName());
    }
  }

  private static void collectionFetchJoin(EntityManager entityManager) {
    String jpql = "select t from Team t join fetch t.members where t.name = 'team1'";
    List<Team> teams = entityManager.createQuery(jpql, Team.class)
      .getResultList();

    for(Team team : teams){
      System.out.println("teamname = " + team.getName());

      //페치 조인으로 팀과 회원을 함께 조회해서 지연 로딩 발생 안함
      for(Member member : team.getMembers()){
        System.out.println(" ->username = " + member.getName()+ ", member = " + member);
      }
    }
  }

  private static void collectionFetchJoinDistinct(EntityManager entityManager) {
    String jpql = "select distinct t from Team t join fetch t.members where t.name = 'team1'";
    List<Team> teams = entityManager.createQuery(jpql, Team.class)
      .getResultList();

    for(Team team : teams){
      System.out.println("teamname = " + team.getName());

      //페치 조인으로 팀과 회원을 함께 조회해서 지연 로딩 발생 안함
      for(Member member : team.getMembers()){
        System.out.println(" ->username = " + member.getName()+ ", member = " + member);
      }
    }
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
