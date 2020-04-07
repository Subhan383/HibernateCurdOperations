package org.hibernate;

import java.util.List;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.entity.User;

public class ListingRecords {

	public static void main(String[] args) {
	StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
	SessionFactory factory=meta.getSessionFactoryBuilder().build();
	Session session=factory.openSession();
	
	try {
		session.beginTransaction();

		List<User> user=session.createQuery("from user").getResultList();
		
		for (User temp : user) {
			System.out.println(temp);
		}
		
		
		
	} finally {
		session.close();
		factory.close();
	}
	
	}

}
