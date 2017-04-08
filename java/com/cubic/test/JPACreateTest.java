
package com.cubic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.entity.Customer;

public class JPACreateTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			System.out.println("Connection Established");
			Customer entity = new Customer();
			entity.setFirstName("sudeep");
			entity.setLastName("stha");
			System.out.println("Before Save" + entity);
			em.persist(entity);
			et.commit();
			
			
			/*
			et.begin();
			em.merge(entity);
			entity.setFirstName("surendra");
			entity.setLastName("thakur");
			em.persist(entity);
			et.commit();*/
			
			
			System.out.println("After Save" + entity);
		

		}

		catch (Exception e) {
			e.printStackTrace();
			et.rollback();

		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}

}
