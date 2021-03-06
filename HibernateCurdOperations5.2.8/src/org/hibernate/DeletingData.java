package org.hibernate;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.entity.User;

public class DeletingData {

	public static void main(String[] args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session=factory.openSession();
        
        try {
			User user=new User();
			session.beginTransaction();
			user=session.get(User.class, 3);
			session.delete(user);
        	session.getTransaction().commit();
        	System.out.println(user);
        	
        	
		} finally {
			session.close();
			factory.close();
		}
	}

}
