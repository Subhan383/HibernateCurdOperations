package org.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.cfg.Configuration;
import org.hibernate.entity.Employee;

public class EmployeeNamedQueryExample {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction trans=session.beginTransaction();
		saveEmp();
		TypedQuery query = session.getNamedQuery("EmployeeNamedQuery");
		List<Employee> employee = query.getResultList();
		Iterator<Employee> iterator = employee.iterator();
		while (iterator.hasNext()) {
			Employee e = iterator.next();
			System.out.println(e);
		}
		session.close();
	}

	

	public static void saveEmp() {
		Employee emp = new Employee();
		emp.setEmployeeID(1);
		emp.setEmployeeName("Subhan");
		emp.setEmployeeDesignation("Software Engineer");
		
	}

}
