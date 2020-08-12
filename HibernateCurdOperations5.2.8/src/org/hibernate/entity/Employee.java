package org.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "EmployeeNamedQuery", query = "from employee e"

		) }

)

@Entity(name = "employee")
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "Employee_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeID;

	@Column(name = "Employee_Name")
	private String employeeName;

	@Column(name = "Employee_Designation")
	private String employeeDesignation;

	public Employee() {

	}

	public Employee(int employeeID, String employeeName, String employeeDesignation) {

		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", employeeName=" + employeeName + ", employeeDesignation="
				+ employeeDesignation + "]";
	}
	
	

}
