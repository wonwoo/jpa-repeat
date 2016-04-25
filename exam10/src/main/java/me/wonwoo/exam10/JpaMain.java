package me.wonwoo.exam10;

import me.wonwoo.exam10.dto.MemberDTO;
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


    TypedQuery<Member> typedQuery = entityManager.createQuery("select m from Member m", Member.class);
    System.out.println(typedQuery.getResultList()
      .stream()
      .map(i -> i.toString())
      .collect(joining("\n"))
    );

    Query queryObject = entityManager.createQuery("select m.name, m.email from Member m");
    List<Object[]> result = queryObject.getResultList();
    result.stream().forEach(i -> {
      System.out.println(i[0]);
      System.out.println(i[1]);
    });

    TypedQuery<Member> nameTypedQuery = entityManager.createQuery("select m from Member m where m.name = :name", Member.class);
    nameTypedQuery.setParameter("name", "wonwoo");
    nameTypedQuery.getResultList().stream().forEach(System.out::println);

    TypedQuery<Member> positionTypedQuery = entityManager.createQuery("select m from Member m where m.name = ?1", Member.class);
    positionTypedQuery.setParameter(1, "wonwoo");
    positionTypedQuery.getResultList().stream().forEach(System.out::println);


    TypedQuery<MemberDTO> queryDto = entityManager.createQuery(
      "select new me.wonwoo.exam10.dto.MemberDTO(m.name, m.email) from Member m", MemberDTO.class
    );
    System.out.println(queryDto.getResultList()
      .stream()
      .map(i -> i.toString())
      .collect(joining("\n")));

    TypedQuery<Member> pageQuery = entityManager.createQuery(
      "select m from Member m ORDER BY m.name desc", Member.class
    );
    pageQuery.setFirstResult(1);
    pageQuery.setMaxResults(2);
    System.out.println(pageQuery.getResultList()
      .stream()
      .map(i -> i.toString())
      .collect(joining("\n")));

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
