package me.wonwoo.exam5;

import me.wonwoo.exam5.model.Member;
import me.wonwoo.exam5.model.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by wonwoo on 2016. 2. 20..
 */
public class JpaMain {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {


        persist();
        find();
        queryLogicJoin();
        update();

    }

    private static void persist(){
        Team team = new Team("team1","팀1");

        Member member1 = new Member("member1","회원1",team);
        Member member2 = new Member("member2","회원2",team);


        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin(); // 트랜잭션 시작
            entityManager.persist(team);
            entityManager.persist(member1);
            entityManager.persist(member2);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    private static void find(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Member member = entityManager.find(Member.class, "member1");
            Team team1 = member.getTeam();
            System.out.println(team1.getName());
        }  finally {
            entityManager.close();
        }
    }

    private static void queryLogicJoin(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String jpql = "select m from Member m join m.team t where t.name=:teamName";
        try {
            entityManager.createQuery(jpql,Member.class)
                    .setParameter("teamName", "팀1")
                    .getResultList()
                    .stream()
                    .map(m -> "[query] member.username : " + m.getUsername())
                    .forEach(System.out::println);
        }finally {
            entityManager.close();
        }

    }

    private static void update(){

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin(); // 트랜잭션 시작

            Team team = new Team("team2","팀2");
            entityManager.persist(team);

            Member member = entityManager.find(Member.class, "member1");
            member.setTeam(team);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

}
