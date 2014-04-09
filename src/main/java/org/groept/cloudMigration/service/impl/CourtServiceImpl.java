package org.groept.cloudMigration.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

import org.groept.cloudMigration.dao.CourtDao;
import org.groept.cloudMigration.dao.HallDao;
import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Hall;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.CapabilityService;
import org.groept.cloudMigration.service.CourtService;
import org.groept.cloudMigration.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourtServiceImpl implements CourtService{

	private ConcurrentMap<String, Court> mapcourts=(ConcurrentMap)(new ClassPathXmlApplicationContext("hazelcast.xml").getBean("courtmap"));
	
	//private ConcurrentMap<String, Capability> mapcapabilities=(ConcurrentMap)(new ClassPathXmlApplicationContext("hazelcast.xml").getBean("capabilitymap"));
	
	@Autowired
	private CapabilityService capabilityService;
	
	@Autowired
	private HallService hallService;
	
	@Override
	public void saveCourt(Court e) {
		// TODO Auto-generated method stub
		 Court oldEm=mapcourts.get(e.getId());
	        if(oldEm==null)
	        {
	        	mapcourts.put(e.getId(), e);
	        	System.out.println("new card");
	        	
	        }
	        	
	        else
	        {
	        	
	        	mapcourts.replace(e.getId(), oldEm, e);
	        	System.out.println("replace card");
	        }
	
	}
	@Override
	public void editCourt(Court e) {
		// TODO Auto-generated method stub
		 Court oldEm=mapcourts.get(e.getId());
	        if(oldEm==null)
	        {
	        	mapcourts.put(e.getId(), e);
	        	System.out.println("new card");
	        	
	        }
	        	
	        else
	        {
	        	
	        	mapcourts.replace(e.getId(), oldEm, e);
	        	System.out.println("replace card");
	        }
	
	}

	@Override
	public void deleteCourt(String i) {
		// TODO Auto-generated method stub
		Court e=mapcourts.get(i);
		if(e!=null)
		{
			mapcourts.remove(e.getId());
			
			
			//remove court for the capability
			for(Capability cap:(List<Capability>)capabilityService.getCapabilities())
			{
				Set<Court> temp=new HashSet<Court>();
				for(Court c:cap.getCourt())
					if(!(c.getId().equals(i)))
						temp.add(c);	
								
				cap.setCourt(temp);
				capabilityService.saveCapability(cap);
				
			}
				
			
			//remove court for the hall		
			for(Hall h:(List<Hall>)hallService.getHalls())
			{
				List<Court> temp=new ArrayList<Court>();
				for(Court c:h.getCourts())
					if(!(c.getId().equals(i)))
						temp.add(c);					
				h.setCourts(temp);
				hallService.saveHall(h);
			}
				
			
		}
	}

	@Override
	public Court getCourt(String i) {
		// TODO Auto-generated method stub
		return mapcourts.get(i);
	}
	

	@Override
	public List getCourts() {
		// TODO Auto-generated method stub
List<Court> Courts=new ArrayList<Court>();
		
		
		for(Map.Entry<String, Court> entry:mapcourts.entrySet())
		{
			
			Courts.add(entry.getValue());
		}
		
		return Courts;

	}
	
	@Override
	public Hall getHall() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Court getCourtByName(String _nameOfCourtRecieved) {
		// TODO Auto-generated method stub
		
		for(Map.Entry<String, Court> entry:mapcourts.entrySet())
		{
			if(entry.getValue().getName().equalsIgnoreCase(_nameOfCourtRecieved))
				return entry.getValue();
		}
		
		return null;
		
	}
	@Override
	public void saveAllCourt(Set<Court> allCourts) {
		// TODO Auto-generated method stub
		
		for(Court c:allCourts)
			mapcourts.put(c.getId(),c);
		
	}

	
}
