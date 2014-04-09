package org.groept.cloudMigration.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class BankCard implements Serializable{
	
	private String id;
	private String name;
	private String cardNumber;
	
	
	private Set<Employee> employees;
	
	
	public BankCard() {
	
		// TODO Auto-generated constructor stub
	}
	public BankCard(String id, String name, String cardNumber) {
		
		this.id = id;
		this.name = name;
		this.cardNumber = cardNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "BankCard [id=" + id + ", name=" + name + ", cardNumber="
				+ cardNumber + "]";
	}
	
	
	
	
	

}
