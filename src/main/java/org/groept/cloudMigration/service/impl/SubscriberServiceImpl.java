package org.groept.cloudMigration.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import org.groept.cloudMigration.dao.ReservationDao;
import org.groept.cloudMigration.dao.SubscriberDao;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Hall;
import org.groept.cloudMigration.model.Reservation;
import org.groept.cloudMigration.model.Subscriber;
import org.groept.cloudMigration.model.TimeInterval;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.ReservationService;
import org.groept.cloudMigration.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class SubscriberServiceImpl implements SubscriberService {

	
	
	private ConcurrentMap<String, Reservation> mapreservations=(ConcurrentMap)(new ClassPathXmlApplicationContext("hazelcast.xml").getBean("reservationmap"));
	private ConcurrentMap<String, Subscriber> mapsubscribers=(ConcurrentMap)(new ClassPathXmlApplicationContext("hazelcast.xml").getBean("subscribermap"));
	
	
	
	@Override
	public void saveSubscriber(Subscriber e) {
		// TODO Auto-generated method stub
		 Subscriber oldEm=mapsubscribers.get(e.getId());
	        if(oldEm==null)
	        {
	        	mapsubscribers.put(e.getId(), e);
	        	System.out.println("new card");
	        	
	        }
	        	
	        else
	        {
	        	
	        	mapsubscribers.replace(e.getId(), oldEm, e);
	        	System.out.println("replace card");
	        }
	
	}
	@Override
	public void editSubscriber(Subscriber e) {
		// TODO Auto-generated method stub
		 Subscriber oldEm=mapsubscribers.get(e.getId());
	        if(oldEm==null)
	        {
	        	mapsubscribers.put(e.getId(), e);
	        	System.out.println("new card");
	        	
	        }
	        	
	        else
	        {
	        	
	        	mapsubscribers.replace(e.getId(), oldEm, e);
	        	System.out.println("replace card");
	        }
	
	}

	@Override
	public void deleteSubscriber(String i) {
		// TODO Auto-generated method stub
		Subscriber e=mapsubscribers.get(i);
		if(e!=null)
		{
			mapsubscribers.remove(e.getId());
			
		}
	}

	@Override
	public Subscriber getSubscriber(String i) {
		// TODO Auto-generated method stub
		return mapsubscribers.get(i);
	}
	
	
	@Override
	public List getSubscribers() {
		// TODO Auto-generated method stub
List<Subscriber> Subscribers=new ArrayList<Subscriber>();
		
		
		for(Map.Entry<String, Subscriber> entry:mapsubscribers.entrySet())
		{
			
			Subscribers.add(entry.getValue());
		}
		
		return Subscribers;
	}
	
	
	@Override
	public void addReservationtoPerson(String subscriberId,Reservation reservation)
	{
		
		Subscriber s=mapsubscribers.get(subscriberId);
		
		//s.addReservation(reservation);
		reservation.setSubscriber(s);
		
		
		mapreservations.put(reservation.getId(), reservation);
		
		mapsubscribers.put(subscriberId, s);
		
	}
	
	
	

}
