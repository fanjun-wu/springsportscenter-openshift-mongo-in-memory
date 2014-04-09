package org.groept.cloudMigration.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

public class Court implements Serializable
{
	

    private String id;
	

	private String name;

	private String introduction;
	
	//private Set<Reservation> reservation;
	
	
	

	

	public Court(String id,String name, String introduction) {
		
		this.id=id;
		this.name = name;
		this.introduction = introduction;
		
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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public void unsetIntroduction() {
		this.introduction = "";	
	}
	
	public void unsetId() {
		this.id = null;	
	}
	
	//@DBRef 
	//@DBRef (lazy = true)
	//private Hall hall;
	
	/*@DBRef(lazy = true)
	private Set<Hall> hall ;
	public void setHall(Hall newHall) {
		if(true) {
			this.hall = new HashSet<Hall>();
			System.out.println(newHall.getName());
			System.out.println("null");
		}
		
		if (this.hall.add(newHall))
		{
		//newCourt.basicSetHall(this);
			System.out.println("set");
		}
	}


	public  Hall getHall() {
		
		
		return hall.iterator().next();
	}

	public void setHall( Set<Hall> hall) {
		this.hall = hall;
	}*/
	
	/*
	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}
	*/

	//@DBRef
	//@DBRef (lazy = true)
	//private Set<Capability> capability;
	


	public Court(){
		
	}

	/*public void basicSetHall(Hall myHall) {
		if (this.hall != myHall) {
			if (myHall != null){
				if (this.hall != myHall) {
					Hall oldhall = this.hall;
					this.hall = myHall;
					if (oldhall != null)
						oldhall.removeCourt(this);
				}
			}
		}	
	}*/
	
	
	
	
	/*
	
	public Set<Capability> getCapability() {
		if(this.capability == null) {
				this.capability = new HashSet<Capability>();
		}
		return (Set<Capability>) this.capability;	
	}
	
	
	

	public void addAllCapability(Set<Capability> newCapability) {
		if (this.capability == null) {
			this.capability = new HashSet<Capability>();
		}
		for (Capability tmp : newCapability)
			tmp.addCourt(this);
			
	}
	
	
	public void removeAllCapability(Set<Capability> newCapability) {
		if(this.capability == null) {
			return;
		}
		
		this.capability.removeAll(newCapability);	
	}
	
	
	*/
	
	

	
	/*public void (Hall myHall) {
		this.basicSetHall(myHall);
		myHall.addCourt(this);	
	}*/
	
	
	/*public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Hall getHall() {
		return hall;
	}*/


/*
	public void setCapability(Set<Capability> capability) {
		this.capability = capability;
	}

	public void addCapability(Capability newCapability) {
		if(this.capability == null) {
			this.capability = new HashSet<Capability>();
		}
		
		if (this.capability.add(newCapability))
			newCapability.addCourt(this);	
	}
	
	
	*/
	
	
	

	/*public void unsetHall() {
		if (this.hall == null)
			return;
		Hall oldhall = this.hall;
		this.hall = null;
		oldhall.removeCourt(this);	
	}
*/
	
	/*
public void removeCapability(Capability oldCapability) {
		if(this.capability == null)
			return;
		
		if (this.capability.remove(oldCapability))
			oldCapability.removeCourt(this);
			
	}
	*/
	
	
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
			tmp.setCourt(this);
			
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
		}
		
		if (this.reservation.add(newReservation))
			newReservation.basicSetCourt(this);	
	}
	
	public void removeReservation(Reservation oldReservation) {
		if(this.reservation == null)
			return;
		
		if (this.reservation.remove(oldReservation))
			oldReservation.unsetCourt();
			
	}
	
	*/
	
	
}

