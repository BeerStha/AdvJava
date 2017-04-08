
package com.cubic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.entity.Customer;
import com.cubic.entity.CustomerInfo;

public class OneToOne {
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
			Customer entity = createCustomerEntity();
			CustomerInfo infoEntity = createCustomerInfo();
			entity.setCustomerinfo(infoEntity);
			infoEntity.setCustomer(entity);
			System.out.println("Before Save" + entity);
			em.persist(entity);
			System.out.println("After Save" + entity);
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
	private static CustomerInfo createCustomerInfo() {
		   CustomerInfo entity = new CustomerInfo();
		   entity.setDesc("Testing 1 to 1");
		   		
		   
		return entity;
	}
	private static Customer createCustomerEntity() {
		Customer entity = new Customer();
		entity.setFirstName("John");
		entity.setLastName("Doe");
		return entity;
	}
	
}
