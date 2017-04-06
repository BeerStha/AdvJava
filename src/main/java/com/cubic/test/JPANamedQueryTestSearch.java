package com.cubic.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cubic.entity.Customer;
import com.cubic.entity.QueryConstants;

public class JPANamedQueryTestSearch {
	public static void main(String[] args) {
	EntityManagerFactory emf = null;
	EntityManager em = null;
	EntityTransaction et = null;
	try{	
		emf= Persistence.createEntityManagerFactory("OracleUnit");
		em = emf.createEntityManager();
		
		TypedQuery<Customer>query = em.createNamedQuery(QueryConstants.CUSTOMER_SEARCH,Customer.class);
		query.setParameter("p1","sure%");
		query.setParameter("p2","%");
		List <Customer> list = query.getResultList();
		for (Customer s:list){
			System.out.println("Customer name"+ s);
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
