package com.cubic.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cubic.entity.Customer;

public class JPANativeQuery {
	public static void main(String[] args) {
	EntityManagerFactory emf = null;
	EntityManager em = null;
	EntityTransaction et = null;
	try{	
		emf= Persistence.createEntityManagerFactory("OracleUnit");
		em = emf.createEntityManager();
		TypedQuery<Customer>query = em.createQuery("select c from Customer c",Customer.class);
		
		
		
		List <Customer> list = (List<Customer>) query.getResultList();
		for (Customer s:list){
			System.out.println("Customer name"+ s );
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
		//et.rollback();
	
	}finally{
		if(em != null){
			em.close();
		}if (emf !=null){
			emf.close();
		}
			
		}
	}

}
