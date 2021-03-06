package org.hibernate;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class UpdateRecordUsingHQL {

	public static void main(String[] args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		
		try {
			session.beginTransaction();
			session.createQuery("update user set fname='subhan' where user_id=3").executeUpdate();
			session.getTransaction().commit();
			
			
		} finally {
			session.close();
			factory.close();
		}
		
		
	}

}
