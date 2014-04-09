package org.groept.cloudMigration.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


public class Capability implements Serializable
{
	 
    private String id;
	
	
	private String resource;

	
	private String conditionCap;
	
	private String discriptionCap;
	 

	private Set<Court> court;

	
	@Override
	public String toString() {
		return "Capability [id=" + id + ", resource=" + resource
				+ ", conditionCap=" + conditionCap + ", discriptionCap="
				+ discriptionCap + "]";
	}



	public Capability(String id,String resource, String conditionCap,
			String discriptionCap) {
		super();
		this.id=id;
		this.resource = resource;
		this.conditionCap = conditionCap;
		this.discriptionCap = discriptionCap;
	}



	public Capability(){
		
	}


	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getResource() {
		return resource;
	}



	public void setResource(String resource) {
		this.resource = resource;
	}



	public String getConditionCap() {
		return conditionCap;
	}



	public void setConditionCap(String conditionCap) {
		this.conditionCap = conditionCap;
	}



	public String getDiscriptionCap() {
		return discriptionCap;
	}



	public void setDiscriptionCap(String discriptionCap) {
		this.discriptionCap = discriptionCap;
	}



	public void unsetId() {
		this.id = null;	
	}

	

	public void setCourt(Set<Court> court) {
		this.court = court;
	}


	public Set<Court> getCourt() {
		if(this.court == null) {
				this.court = new HashSet<Court>();
		}
		return (Set<Court>) this.court;	
	}
	


	
	/*

	public void addAllCourt(Set<Court> newCourt) {
		if (this.court == null) {
			this.court = new HashSet<Court>();
		}
		for (Court tmp : newCourt)
			tmp.addCapability(this);
			
	}
	*/
	
	
	

	public void removeAllCourt(Set<Court> newCourt) {
		if(this.court == null) {
			return;
		}
		
		this.court.removeAll(newCourt);	
	}
	

	
	
	
/*

 
	public void addCourt(Court newCourt) {
		if(this.court == null) {
			this.court = new HashSet<Court>();
		}
		
		if (this.court.add(newCourt))
			newCourt.addCapability(this);	
	}

*/

	public void unsetResource() {
		this.resource = "";	
	}
	

	public void unsetCondition() {
		this.conditionCap = "";	
	}
	

	public void unsetDiscription() {
		this.discriptionCap = "";	
	}

	


/*

public void removeCourt(Court oldCourt) {
		if(this.court == null)
			return;
		
		if (this.court.remove(oldCourt))
			oldCourt.removeCapability(this);
			
	}
*/
	
	
}

