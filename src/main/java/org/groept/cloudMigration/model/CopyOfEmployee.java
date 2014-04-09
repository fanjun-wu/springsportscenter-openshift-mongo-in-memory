package org.groept.cloudMigration.model;

import java.io.Serializable;

public class CopyOfEmployee implements Serializable {
private int id;
private String name;
private int age;
private boolean active;
private double salary;

public CopyOfEmployee(int id,String name, int age, boolean live, double price) {
    this.id=id;
	this.name = name;
    this.age = age;
    this.active = live;
    this.salary = price;
}

public CopyOfEmployee() {
}

public String getName() {
    return name;
}

public int getAge() {
    return age;
}

public double getSalary() {
    return salary;
}

public boolean isActive() {
    return active;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

@Override
public String toString()
{
	if(name==null)
		return null;
	else
		return "info// name:"+name+", age: "+age+", alive: "+active+", price: "+salary;

}


}