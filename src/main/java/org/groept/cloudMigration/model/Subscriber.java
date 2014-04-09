package org.groept.cloudMigration.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

public class Subscriber extends Person implements Serializable
{
	
	private String authenKey;
	
	//private Set<Reservation> reservation;

	public Subscriber(){
		
	}


/*	
	public void setReservation(Set<Reservation> reservation) {
		this.reservation = reservation;
	}



	public Set<Reservation> getReservation() {
		if(this.reservation == null) {
				this.reservation = new HashSet<Reservation>();
		}
		return (Set<Reservation>) this.reservation;	
	}

	public void addAllReservation(Set<Reservation> newReservation) {
		if (this.reservation == null) {
			this.reservation = new HashSet<Reservation>();
		}
		for (Reservation tmp : newReservation)
			tmp.setSubscriber(this);
			
	}
	
	
	public void removeAllReservation(Set<Reservation> newReservation) {
		if(this.reservation == null) {
			return;
		}
		
		this.reservation.removeAll(newReservation);	
	}
	

	
	
	public void addReservation(Reservation newReservation) {
		if(this.reservation == null) {
			this.reservation = new HashSet<Reservation>();
			System.out.println("woshi kong");
		}
		
		if (this.reservation.add(newReservation));
			//newReservation.basicSetSubscriber(this);	
	}
	
		
	
	public void removeReservation(Reservation oldReservation) {
		if(this.reservation == null)
			return;
		
		if (this.reservation.remove(oldReservation))
			oldReservation.unsetSubscriber();
			
	}
	*/
	
	
	public Subscriber(String id,String name, String email, String telephone,
			String gender, int age,String authenKey) {
		super(id,name, email, telephone, gender, age);
		this.authenKey=authenKey;
		// TODO Auto-generated constructor stub
	}


	public String getAuthenKey() {
		return authenKey;
	}


	public void setAuthenKey(String authenKey) {
		this.authenKey = authenKey;
	}


	public void unsetAuthenKey() {
		this.authenKey = "";	
	}
	
}

