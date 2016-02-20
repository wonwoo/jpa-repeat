package me.wonwoo.exam5;

import me.wonwoo.exam5.model.Member5;
import me.wonwoo.exam5.model.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

        deleteRelation();
        biDirection();
        test순수한객체_양방향();
        test순수한객체_양방향1();
        testORM_양방향();
        entityManagerFactory.close();

    }


    private static void persist() {
        Team team = new Team("team1", "팀1");

        Member5 member1 = new Member5("member1", "회원1", team);
        Member5 member2 = new Member5("member2", "회원2", team);
        Member5 member3 = new Member5("member3", "회원3", team);


        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin(); // 트랜잭션 시작
            entityManager.persist(team);
            entityManager.persist(member1);
            entityManager.persist(member2);
            entityManager.persist(member3);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    private static void find() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Member5 member = entityManager.find(Member5.class, "member1");
            Team team1 = member.getTeam();
            System.out.println(team1.getName());
        } finally {
            entityManager.close();
        }
    }

    private static void queryLogicJoin() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String jpql = "select m from Member5 m join m.team t where t.name=:teamName";
        try {
            entityManager.createQuery(jpql, Member5.class)
                    .setParameter("teamName", "팀1")
                    .getResultList()
                    .stream()
                    .map(m -> "[query] member.username : " + m.getUsername())
                    .forEach(System.out::println);
        } finally {
            entityManager.close();
        }
    }

    private static void update() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin(); // 트랜잭션 시작

            Team team = new Team("team2", "팀2");
            entityManager.persist(team);

            Member5 member = entityManager.find(Member5.class, "member1");
            member.setTeam(team);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    private static void deleteRelation() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin(); // 트랜잭션 시작

            Team team = entityManager.find(Team.class, "team2");
            Member5 member1 = entityManager.find(Member5.class, "member1");
            member1.setTeam(null); // 연관관계 제거

            entityManager.remove(team);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    private static void biDirection() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Team member = entityManager.find(Team.class, "team1");
            member.getMembers()
                    .stream()
                    .map(t -> "member.username : " + t.getUsername())
                    .forEach(System.out::println);
        } finally {
            entityManager.close();
        }
    }

    private static void test순수한객체_양방향() {
        Team team = new Team("team10", "팀10");

        Member5 member10 = new Member5("member10", "회원10");
        Member5 member11 = new Member5("member11", "회원11");

        member10.setTeam(team);
        member11.setTeam(team);

        System.out.println(team.getMembers().stream().count()); //0
    }
    private static void test순수한객체_양방향1() {
        Team team = new Team("team10", "팀10");

        Member5 member10 = new Member5("member10", "회원10");
        Member5 member11 = new Member5("member11", "회원11");

        member10.setTeam(team);
        team.getMembers().add(member10);

        member11.setTeam(team);
        team.getMembers().add(member11);

        System.out.println(team.getMembers().stream().count()); //2
    }

    private static void testORM_양방향(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin(); // 트랜잭션 시작

            Team team = new Team("team10", "팀10");
            entityManager.persist(team);

            Member5 member10 = new Member5("member10", "회원10");
            member10.setTeam(team); //연관관계의 주인이다
//            team.getMembers().add(member10); //주인이 아니다 저장시 사용하지 않는다.

            entityManager.persist(member10);

            Member5 member11 = new Member5("member11", "회원11");
            member11.setTeam(team); //연관관계 주인이다.
//            team.getMembers().add(member11); //주인이 아니다

            entityManager.persist(member11);


            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }


    }
}

