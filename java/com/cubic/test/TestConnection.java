package com.cubic.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
EntityManagerFactory emf =null;
EntityManager em = null;
try{
	emf = Persistence.createEntityManagerFactory("OracleUnit");
	em = emf.createEntityManager();
			System.out.println("Connection Established");
}finally{
	if (em!=null){
		em.close();
	}if (emf != null){
		emf.close();
	}
}
	}

}
