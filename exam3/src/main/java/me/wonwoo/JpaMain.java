package me.wonwoo;


import me.wonwoo.model.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static java.util.stream.Collectors.*;

/**
 * Created by wonwoo on 2016. 2. 20..
 */
public class JpaMain {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        EntityTransaction transaction = entityManager.getTransaction();
//
//        try {
//            transaction.begin(); // 트랜잭션 시작
//            persist(entityManager);
//            update(entityManager);
//            remove(entityManager);
//            transaction.commit();
//        } catch (Exception e) {
//            transaction.rollback();
//        } finally {
//            entityManager.close();
//        }

//        print();

        ///////***********************************//////////

//        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction2 = entityManager2.getTransaction();
//        try {
//            transaction2.begin(); // 트랜잭션 시작
//            detached(entityManager2);
//            transaction2.commit();
//        } catch (Exception e) {
//            transaction2.rollback();
//        } finally {
//            entityManager2.close();
//        }
//
//        print();


        Member member = createMember("id4", "회원B", 31);
        //준영속일때 변경
        member.setUsername("병합");
        merge(member);
        print();

        entityManagerFactory.close();
    }

    private static Member createMember(String id, String name, Integer age) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Member member = new Member(id, name, age);
        try {
            transaction.begin(); // 트랜잭션 시작
            entityManager.persist(member);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        return member;
    }


    private static void merge(Member member) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin(); // 트랜잭션 시작
            Member mergeMember = entityManager.merge(member);
            System.out.println("entityManager.contains(mergeMember) : " +
                    entityManager.contains(mergeMember)
            );
            System.out.println("entityManager.contains(member) : " +
                    entityManager.contains(member));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }


    private static void detached(EntityManager entityManager) {
        Member member3 = new Member("Id3", "회원A", 40);
        entityManager.persist(member3);
        entityManager.detach(member3); // 준영속으로 전환
    //    entityManager.clear();   //모든 엔티티를 준영속 전환
    //    entityManager.close(); // 영속성 컨텍스트 종료
    }

    //대상을 삭제 하려면 엔티티를 조회해야 된다.
    private static void remove(EntityManager entityManager) {
        Member member1 = entityManager.find(Member.class, "id1");
        entityManager.remove(member1);
    }

    //변경감지
    private static void update(EntityManager entityManager) {

        Member member2 = entityManager.find(Member.class, "id2");
        member2.setUsername("hello");
        member2.setAge(40);
//        entityManager.update(member2)  //이런 코드 없다. 일명 변경 감지
    }

    //insert
    private static void persist(EntityManager entityManager) {
        Member member1 = new Member("id1", "원우", 2);
        Member member2 = new Member("id2", "케빈", 20);
        entityManager.persist(member1);
        entityManager.persist(member2);
    }


    private static void print() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Member> members = entityManager.createQuery("select m from Member m", Member.class).getResultList();

        System.out.println(members.stream().collect(toList()));
        System.out.println("members.size=" + members.size());
    }

}
