package org.groept.cloudMigration.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import org.groept.cloudMigration.dao.CourtDao;
import org.groept.cloudMigration.dao.HallDao;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.model.Hall;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HallServiceImpl implements HallService {

	
	
	private ConcurrentMap<String, Court> mapcourts=(ConcurrentMap)(new ClassPathXmlApplicationContext("hazelcast.xml").getBean("courtmap"));
	private ConcurrentMap<String, Hall> maphalls=(ConcurrentMap)(new ClassPathXmlApplicationContext("hazelcast.xml").getBean("hallmap"));
	

	
	@Override
	public void saveHall(Hall e) {
		// TODO Auto-generated method stub
		 Hall oldEm=maphalls.get(e.getId());
	        if(oldEm==null)
	        {
	        	maphalls.put(e.getId(), e);
	        	System.out.println("new card");
	        	
	        }
	        	
	        else
	        {
	        	
	        	maphalls.replace(e.getId(), oldEm, e);
	        	System.out.println("replace card");
	        }
	
	}
	@Override
	public void editHall(Hall e) {
		// TODO Auto-generated method stub
		 Hall oldEm=maphalls.get(e.getId());
	        if(oldEm==null)
	        {
	        	maphalls.put(e.getId(), e);
	        	System.out.println("new card");
	        	
	        }
	        	
	        else
	        {
	        	
	        	maphalls.replace(e.getId(), oldEm, e);
	        	System.out.println("replace card");
	        }
	
	}

	@Override
	public void deleteHall(String i) {
		// TODO Auto-generated method stub
		Hall e=maphalls.get(i);
		if(e!=null)
		{
			maphalls.remove(e.getId());
			
		}
	}

	@Override
	public Hall getHall(String i) {
		// TODO Auto-generated method stub
		return maphalls.get(i);
	}
	

	@Override
	public List<Hall> getHalls() {
		// TODO Auto-generated method stub
List<Hall> Halls=new ArrayList<Hall>();
		
		
		for(Map.Entry<String, Hall> entry:maphalls.entrySet())
		{
			
			Halls.add(entry.getValue());
		}
		
		return Halls;
	}
	
	
	@Override
	public void addCourt(String hallId, String courtId) {
		// TODO Auto-generated method stub
		
		//Court c=courtDao.findById(courtId);
		Court c=mapcourts.get(courtId);
		
		
		Hall h=maphalls.get(hallId);
		//c.setHall(h);
		
		h.addCourt(c);
		
		
		maphalls.put(h.getId(), h);
		mapcourts.put(c.getId(), c);
		
			
	}
	
	
	
	@Override
	public List listofCourts(String hallId){
		
		return maphalls.get(hallId).getCourts();
		
	}
	

}
