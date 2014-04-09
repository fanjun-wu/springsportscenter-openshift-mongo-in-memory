package org.groept.cloudMigration.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



public abstract class Person
{
	
    private String id;
		
	private String name;
	
	private String email;
	

	private String telephone;
	
	private String gender;
	
	private int age;
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public Person(String id,String name, String email, String telephone,
			String gender, int age) {
		
		this.id=id;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.gender = gender;
		this.age = age;
	}



	public Person(){
		
	}

	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}




 
}

