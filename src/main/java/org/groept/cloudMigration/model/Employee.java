package org.groept.cloudMigration.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Employee implements Serializable {
private String id;
private String name;
private int age;
private boolean active;
private double salary;

private Set<BankCard> cards;

public Employee() {
	
	// TODO Auto-generated constructor stub
}

public Employee(String id, String name, int age, boolean active, double salary
		) {

	this.id = id;
	this.name = name;
	this.age = age;
	this.active = active;
	this.salary = salary;
	
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

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public boolean isActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}

public double getSalary() {
	return salary;
}

public void setSalary(double salary) {
	this.salary = salary;
}

public Set<BankCard> getCards() {
	return cards;
}

public void setCards(Set<BankCard> cards) {
	this.cards = cards;
}




}