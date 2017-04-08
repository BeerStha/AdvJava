package com.cubic.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cubic.entity.Customer;
import com.cubic.entity.QueryConstants;

public class JPATypedQueryCount {
	public static void main(String[] args) {
	EntityManagerFactory emf = null;
	EntityManager em = null;
	EntityTransaction et = null;
	try{	
		emf= Persistence.createEntityManagerFactory("OracleUnit");
		em = emf.createEntityManager();
		Long count =  (Long) em.createNamedQuery(QueryConstants.CUSTOMER_COUNT).getSingleResult();
		System.out.println(count);
		
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
