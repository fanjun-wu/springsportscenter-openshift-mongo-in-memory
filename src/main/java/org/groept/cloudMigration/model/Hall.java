package org.groept.cloudMigration.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



public class Hall implements Serializable
{
	
	
    private String id;
	
	private String name;
	
	private int openTime;
	
	private int closeTime;
	
	private String introduction;
	
	
	

	/*@Override
	public String toString() {
		return "Hall [id=" + id + ", name=" + name + ", openTime=" + openTime
				+ ", closeTime=" + closeTime + ", introduction=" + introduction
				+ ", admin=" + admin + ", courts=" + courts + "]";
	}*/
	
	


	public Hall(String id,String name, int openTime, int closeTime, String introduction) {
		this.id=id;
		this.name = name;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.introduction = introduction;
	}



	private Admin admin;
	

	private List<Court> courts ;
	
	
	public List<Court> getCourts() {
		return courts;
	}

	public void setCourts(List<Court> courts) {
		this.courts = courts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOpenTime() {
		return openTime;
	}

	public void setOpenTime(int openTime) {
		this.openTime = openTime;
	}

	public int getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(int closeTime) {
		this.closeTime = closeTime;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String  getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	
	

	public Hall(){
		
	}

	/*

	public void basicSetAdmin(Admin myAdmin) {
		if (this.admin != myAdmin) {
			if (myAdmin != null){
				if (this.admin != myAdmin) {
					Admin oldadmin = this.admin;
					this.admin = myAdmin;
					if (oldadmin != null)
						oldadmin.unsetHall();
				}
			}
		}	
	}*/
	
	

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Admin getAdmin() {
		return this.admin;	
	}

	public List<Court> getCourt() {
		if(this.courts == null) {
				this.courts = new ArrayList<Court>();
		}
		return (List<Court>) this.courts;	
	}
	
	
	/*public void addAllCourt(List<Court> newCourt) {
		if (this.courts == null) {
			this.courts = new ArrayList<Court>();
		}
		for (Court tmp : newCourt)
			tmp.setHall(this);
			
	}*/
	
	public void removeAllCourt(List<Court> newCourt) {
		if(this.courts == null) {
			return;
		}
		
		this.courts.removeAll(newCourt);	
	}
	
	

	
	
	
	public void addCourt(Court newCourt) {
		if(this.courts == null) {
			this.courts = new ArrayList<Court>();
			System.out.println(newCourt.getName());
			System.out.println("null");
		}
		
		if (this.courts.add(newCourt))
		{
		//newCourt.basicSetHall(this);
			System.out.println("set");
		}
	}
	
	
	
	

	
	
/*public void setAdmin(Admin myAdmin) {
		this.basicSetAdmin(myAdmin);
		myAdmin.basicSetHall(this);
			
	}*/

	/*
	public void unsetAdmin() {
		if (this.admin == null)
			return;
		Admin oldadmin = this.admin;
		this.admin = null;
		oldadmin.unsetHall();	
	}
	*/
	
	/*public void removeCourt(Court oldCourt) {
		if(this.courts == null)
			return;
		
		if (this.courts.remove(oldCourt));
			oldCourt.unsetHall();
			
	}*/

	

	
}

