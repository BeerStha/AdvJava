package com.cubic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.entity.Customer;

public class JPADelete {
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
			Customer entity = em.find(Customer.class, new Long(1003));
			System.out.println("Before Save" + entity);
			em.remove(entity);

			et.commit();

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
