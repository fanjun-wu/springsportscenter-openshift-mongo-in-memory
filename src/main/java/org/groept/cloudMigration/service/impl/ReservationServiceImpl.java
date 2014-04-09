package org.groept.cloudMigration.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import org.groept.cloudMigration.dao.ReservationDao;
import org.groept.cloudMigration.dao.TimeIntervalDao;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.model.Hall;
import org.groept.cloudMigration.model.Reservation;
import org.groept.cloudMigration.model.TimeInterval;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{

	
	private ConcurrentMap<String, Reservation> mapreservations=(ConcurrentMap)(new ClassPathXmlApplicationContext("hazelcast.xml").getBean("reservationmap"));
	private ConcurrentMap<String, TimeInterval> maptimeintervals=(ConcurrentMap)(new ClassPathXmlApplicationContext("hazelcast.xml").getBean("timeintervalmap"));
	
	
	@Override
	public void saveReservation(Reservation e) {
		// TODO Auto-generated method stub
		 Reservation oldEm=mapreservations.get(e.getId());
	        if(oldEm==null)
	        {
	        	mapreservations.put(e.getId(), e);
	        	System.out.println("new card");
	        	
	        }
	        	
	        else
	        {
	        	
	        	mapreservations.replace(e.getId(), oldEm, e);
	        	System.out.println("replace card");
	        }
	
	}
	@Override
	public void editReservation(Reservation e) {
		// TODO Auto-generated method stub
		 Reservation oldEm=mapreservations.get(e.getId());
	        if(oldEm==null)
	        {
	        	mapreservations.put(e.getId(), e);
	        	System.out.println("new card");
	        	
	        }
	        	
	        else
	        {
	        	
	        	mapreservations.replace(e.getId(), oldEm, e);
	        	System.out.println("replace card");
	        }
	
	}

	@Override
	public void deleteReservation(String i) {
		// TODO Auto-generated method stub
		Reservation e=mapreservations.get(i);
		if(e!=null)
		{
			mapreservations.remove(e.getId());
			
		}
	}

	@Override
	public Reservation getReservation(String i) {
		// TODO Auto-generated method stub
		return mapreservations.get(i);
	}
	

	@Override
	public List getReservations() {
		// TODO Auto-generated method stub
		
List<Reservation> Reservations=new ArrayList<Reservation>();
		
		
		for(Map.Entry<String, Reservation> entry:mapreservations.entrySet())
		{
			
			Reservations.add(entry.getValue());
		}
		
		return Reservations;

	}
	
	@Override
	public void addTimeInterval(String tId, String rId)
	{
		
		
		
		
		TimeInterval t=maptimeintervals.get(tId);
		Reservation r=mapreservations.get(rId);
		
		r.addTimeInterval(t);
		
		//t.addReservation(r);
		
		
		saveReservation(r);
		maptimeintervals.put(t.getId(), t);
		
		
		
	}
}
