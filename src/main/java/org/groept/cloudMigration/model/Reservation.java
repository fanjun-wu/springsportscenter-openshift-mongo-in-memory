package org.groept.cloudMigration.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


public class Reservation implements Serializable
{
	
    private String id;

	private String discription;

	private String tips;
	 
	private Subscriber subscriber;
	 
	private Set<TimeInterval> timeInterval;
	 
	private Court court;
	 
	
 
	public Reservation(String id,String discription, String tips) {
		this.id=id;
		this.discription = discription;
		this.tips = tips;
	}

	public void setTimeInterval(Set<TimeInterval> timeInterval) {
		this.timeInterval = timeInterval;
	}

	public Reservation(){
		
	}
	/*
 
	public void basicSetSubscriber(Subscriber mySubscriber) {
		if (this.subscriber != mySubscriber) {
			if (mySubscriber != null){
				if (this.subscriber != mySubscriber) {
					Subscriber oldsubscriber = this.subscriber;
					this.subscriber = mySubscriber;
					if (oldsubscriber != null)
						oldsubscriber.removeReservation(this);
				}
			}
		}	
	}
	*/
	 
	
	/*
	public void basicSetCourt(Court myCourt) {
		if (this.court != myCourt) {
			if (myCourt != null){
				if (this.court != myCourt) {
					Court oldcourt = this.court;
					this.court = myCourt;
					if (oldcourt != null)
						oldcourt.removeReservation(this);
				}
			}
		}	
	}
	*/
	
	
	
	
	  
	public String getId() {
		return id;
	}






	public String getDiscription() {
		return discription;
	}






	public void setDiscription(String discription) {
		this.discription = discription;
	}






	public String getTips() {
		return tips;
	}






	public void setTips(String tips) {
		this.tips = tips;
	}






	public void setId(String id) {
		this.id = id;
	}


	public void unsetId() {
		this.id = null;	
	}



	
	
 
	public Subscriber getSubscriber() {
		return this.subscriber;	
	}
	 
	public Set<TimeInterval> getTimeInterval() {
		if(this.timeInterval == null) {
				this.timeInterval = new HashSet<TimeInterval>();
		}
		return (Set<TimeInterval>) this.timeInterval;	
	}
	 
	public Court getCourt() {
		return this.court;	
	}
	
	/*
	
	public void addAllTimeInterval(Set<TimeInterval> newTimeInterval) {
		if (this.timeInterval == null) {
			this.timeInterval = new HashSet<TimeInterval>();
		}
		for (TimeInterval tmp : newTimeInterval)
			tmp.addReservation(this);
			
	}
	 
	 */
	 
	public void removeAllTimeInterval(Set<TimeInterval> newTimeInterval) {
		if(this.timeInterval == null) {
			return;
		}
		
		this.timeInterval.removeAll(newTimeInterval);	
	}
	
	
 
	
	
	 
	/*public void setSubscriber(Subscriber mySubscriber) {
		this.basicSetSubscriber(mySubscriber);
		mySubscriber.addReservation(this);	
	}*/
	
	 
	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	
	public void addTimeInterval(TimeInterval newTimeInterval) {
		if(this.timeInterval == null) {
			this.timeInterval = new HashSet<TimeInterval>();
		}
		
		timeInterval.add(newTimeInterval);
		//newTimeInterval.addReservation(this);	
	}
	 
	/*public void setCourt(Court myCourt) {
		this.basicSetCourt(myCourt);
		myCourt.addReservation(this);	
	}*/
	
	 
	
	
	
	
	
	 
	public void unsetDiscription() {
		this.discription = "";	
	}
	
	 
	public void setCourt(Court court) {
		this.court = court;
	}

	public void unsetTips() {
		this.tips = "";	
	}
	
	/*
	 
	public void unsetSubscriber() {
		if (this.subscriber == null)
			return;
		Subscriber oldsubscriber = this.subscriber;
		this.subscriber = null;
		oldsubscriber.removeReservation(this);	
	}
	
	 
	public void removeTimeInterval(TimeInterval oldTimeInterval) {
		if(this.timeInterval == null)
			return;
		
		if (this.timeInterval.remove(oldTimeInterval))
			oldTimeInterval.removeReservation(this);
			
	}
*/	
 
	
	/*
	public void unsetCourt() {
		if (this.court == null)
			return;
		Court oldcourt = this.court;
		this.court = null;
		oldcourt.removeReservation(this);	
	}
	
	 */
	
	
	
	
	
}

