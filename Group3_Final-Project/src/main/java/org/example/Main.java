package org.example;

import org.example.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // entityManagerFactory 는 어플리케이션에 단 1개 만들어지는 객체
        EntityManager em = emf.createEntityManager(); //요청마다 만들어지는 객체 -> 영속성 컨테스트 객체 생성
        EntityTransaction tx = em.getTransaction(); //영속성 컨테스트 객체 생성
        tx.begin();

        //더미 데이터 . 2개 삽입 .
        Member m1 = new Member();
        m1.setMem_name("test1");
        m1.setMem_pw("321");
        em.persist(m1);

        Member m2 = new Member();
        m2.setMem_name("test2");
        m2.setMem_pw("123");
        em.persist(m2);

        em.flush(); //쿼리 바로 날리기
        tx.commit(); //영속성 컨테스트를 삭제 -> db 에 쿼리문을 보내줌.


        //객체 생성후에 객체를 저장해줌 .
    }
}