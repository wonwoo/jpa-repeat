package me.wonwoo.exam2;

import me.wonwoo.exam2.model.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by wonwoo on 2016. 2. 20..
 */
public class JpaMain {
    public static void main(String[] args) {
        //엔티티 매니저 팩토리 생성 (이 아이는 생성하는 비용이 아주 크다. 애플리케이션 전체에 딱 한 번만 생성하고 공유해서 사용한다.)
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");

        //엔티티 매니저 생성 (비용이 많이 안든다.)
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //트랜잭션 획득
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin(); // 트랜잭션 시작
            logic(entityManager);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }

    private static void logic(EntityManager entityManager) {
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("원우");
        member.setAge(2);

        entityManager.persist(member);
        member.setAge(20);

        Member findMember = entityManager.find(Member.class, id);
        System.out.println(
                "findMember=" + findMember.getUsername() +
                ", age=" + findMember.getAge()
        );
                                                        //JPQL
        List<Member> members = entityManager.createQuery("select m from Member m" , Member.class).getResultList();

        System.out.println(members.stream().collect(toList()));
        System.out.println("members.size=" + members.size());


    }
}
