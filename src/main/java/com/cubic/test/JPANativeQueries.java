package com.cubic.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cubic.entity.QueryConstants;

public class JPANativeQueries {
	public static void main(String[] args) {
	EntityManagerFactory emf = null;
	EntityManager em = null;
	EntityTransaction et = null;
	try{	
		emf= Persistence.createEntityManagerFactory("OracleUnit");
		em = emf.createEntityManager();

		Query query = em.createNamedQuery(QueryConstants.NATIVE_CUSTOMER_SEARCH);
				List <Object[]> list = (List<Object[]>) query.getResultList();
		
				for (Object[] eachRow :list){
			System.out.println(eachRow[0]+ " "+ eachRow[1]);
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
