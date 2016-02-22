package me.wonwoo.exam6;

import me.wonwoo.exam6.model.Member;
import me.wonwoo.exam6.model.Order;
import me.wonwoo.exam6.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by wonwoo on 2016. 2. 22..
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
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            entityManager.close();
        }

        EntityManager entityManager1 = entityManagerFactory.createEntityManager();

        //트랜잭션 획득
        EntityTransaction transaction1 = entityManager1.getTransaction();

        try {
            transaction1.begin(); // 트랜잭션 시작
            find(entityManager1);
            transaction1.commit();
        }catch (Exception e){
            transaction1.rollback();
        }finally {
            entityManager1.close();
        }

//        EntityManager entityManager2 = entityManagerFactory.createEntityManager();

        //트랜잭션 획득
//        EntityTransaction transaction2 = entityManager2.getTransaction();
//
//        try {
//            transaction2.begin(); // 트랜잭션 시작
//            findInverse(entityManager2);
//            transaction2.commit();
//        }catch (Exception e){
//            transaction2.rollback();
//        }finally {
//            entityManager2.close();
//        }

        entityManagerFactory.close();
    }

    private static void save(EntityManager entityManager){


        Member member1 = new Member();
        member1.setUsername("회원1");
        entityManager.persist(member1);

        Member member2 = new Member();
        member2.setUsername("회원1");
        entityManager.persist(member2);

        Product productA = new Product();
        productA.setId("productA");
        productA.setName("상품A");
        entityManager.persist(productA);

        Order order = new Order();
        order.setMember(member1);
        order.setProduct(productA);
        order.setOrderAmount(10);
        entityManager.persist(order);

    }

    private static void find(EntityManager entityManager) {

        Order order = entityManager.find(Order.class, 1L);

        Member member = order.getMember();
        Product product = order.getProduct();


        System.out.println("member = " + member.getUsername());
        System.out.println("product = " + product.getName());
        System.out.println("orderAmount = " + order.getOrderAmount());


    }

//    private static void save(EntityManager entityManager){
//
//
//        Member member1 = new Member();
//        member1.setUsername("회원1");
//        entityManager.persist(member1);
//
//        Product productA = new Product();
//        productA.setId("productA");
//        productA.setName("상품A");
//        entityManager.persist(productA);
//
//        MemberProduct memberProduct = new MemberProduct();
//        memberProduct.setMember(member1);
//        memberProduct.setProduct(productA);
//        memberProduct.setOrderAmount(3);
//        entityManager.persist(memberProduct);
//
//    }
//    private static void find(EntityManager entityManager) {
//        MemberProductId memberProductId = new MemberProductId();
//        memberProductId.setMember(1L);
//        memberProductId.setProduct("productA");
//
//        MemberProduct memberProduct = entityManager.find(MemberProduct.class,memberProductId);
//        Member member = memberProduct.getMember();
//        Product product = memberProduct.getProduct();
//
//        System.out.println("member = " + member.getUsername());
//        System.out.println("product = " + product.getName());
//        System.out.println("orderAmount = " + memberProduct.getOrderAmount());
//
//
//    }

//    private static void find(EntityManager entityManager) {
//        Member member = entityManager.find(Member.class, 1L);
//        member.getProducts()
//                .stream()
//                .map(mb -> "product.name : " + mb.getName())
//                .forEach(System.out::println);
//
//    }


    private static void findInverse(EntityManager entityManager) {
//        Product product = entityManager.find(Product.class,"productA");
//
//        product.getMembers()
//                .stream()
//                .map(member -> "username : " + member.getUsername())
//                .forEach(System.out::println);

    }

//    private static void save(EntityManager entityManager) {
//        Product productA = new Product();
//        productA.setId("productA");
//        productA.setName("상품A");
//        entityManager.persist(productA);
//
//        Member member1 = new Member();
//        member1.setUsername("회원1");
//        member1.getProducts().add(productA);
//        entityManager.persist(member1);
//    }
}
