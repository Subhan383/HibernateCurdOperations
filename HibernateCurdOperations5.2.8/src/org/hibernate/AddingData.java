package org.hibernate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.entity.User;

public class AddingData {

	public static void main(String[] args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		
		try {
			
			User user=new User("ssubhan", "sailajasubhan", "kanna", "Subhan");

			Transaction trans=session.beginTransaction();
			session.save(user);

			session.getTransaction().commit();
			System.out.println("Rows added!");
			
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
