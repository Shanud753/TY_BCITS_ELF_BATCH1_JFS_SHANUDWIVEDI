package com.bcits.jpawithhibernatepractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernatepractice.bean.Demo;

public class App 
{
    public static void main( String[] args )
    {
       Demo demo = new Demo();
       demo.setEid(12);
       demo.setEname("Manish");
       demo.setMobile_no(98765432);
       demo.setOfficial_mailid("manish1@gmail.com");
       demo.setDob(java.sql.Date.valueOf("1996-12-14"));
       demo.setDoj(java.sql.Date.valueOf("2017-10-24"));
       demo.setDesignation("manager");
       demo.setBld_grp("b+");
       demo.setSalary(50000.0);
       demo.setDepId(40);
       demo.setMrgId(103);
       
   	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo");
   	EntityManager manager = entityManagerFactory.createEntityManager();
   	EntityTransaction transaction = manager.getTransaction();
   	transaction.begin();
   	manager.persist(demo);
   	System.out.println("Record Saved");
   	transaction.commit();
   	manager.close();
    }
}
