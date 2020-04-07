package org.hibernate;

import java.util.List;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.entity.User;

public class HQLWhereClause {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();

		try {
			List<User> user = session.createQuery("from user where fname='shaik'" + "OR lname='sailu'").getResultList();
			session.beginTransaction();
			for (User temp : user) {
				System.out.println(temp);
			}

		} finally {
			session.close();
			factory.close();
		}

	}

}
