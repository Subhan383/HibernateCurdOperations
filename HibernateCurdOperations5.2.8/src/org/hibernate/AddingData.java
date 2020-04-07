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
//			List<User> list=new LinkedList<>();
//			User user1=new User("ssubhan", "sailajasubhan", "kanna", "Subhan");
//			User user2=new User("sailu", "sailajasubhan", "kanna", "Azma");
//			User user3=new User("arhaa", "arhaajasubhan", "arhaashaik", "Arhaa");
//			User user4=new User("arhaan", "arhaanjasubhan", "arhaanshaik", "Arhaan");
//			User user5=new User("aarohi", "aarohisubhan", "aarohishaik", "Aarohi");
//			list.add(user1);
//			list.add(user2);
//			list.add(user3);
//			list.add(user4);
//			list.add(user5);
			Transaction trans=session.beginTransaction();
			session.save(user);
//			session.save(user2);
//			session.save(user3);
//			session.save(user4);
//			session.save(user5);
			session.getTransaction().commit();
			System.out.println("Rows added!");
			
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
