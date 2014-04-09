package org.groept.cloudMigration.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import org.groept.cloudMigration.dao.CapabilityDao;
import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.CapabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class CapabilityServiceImpl  implements CapabilityService{

	
	
	private ConcurrentMap<String, Capability> mapcapabilities=(ConcurrentMap)(new ClassPathXmlApplicationContext("hazelcast.xml").getBean("capabilitymap"));
	
	
	
	@Override
	public void saveCapability(Capability e) {
		// TODO Auto-generated method stub
		 Capability oldEm=mapcapabilities.get(e.getId());
	        if(oldEm==null)
	        {
	        	mapcapabilities.put(e.getId(), e);
	        	System.out.println("new card");
	        	
	        }
	        	
	        else
	        {
	        	
	        	mapcapabilities.replace(e.getId(), oldEm, e);
	        	System.out.println("replace card");
	        }
	
	}
	@Override
	public void editCapability(Capability e) {
		// TODO Auto-generated method stub
		 Capability oldEm=mapcapabilities.get(e.getId());
	        if(oldEm==null)
	        {
	        	mapcapabilities.put(e.getId(), e);
	        	System.out.println("new card");
	        	
	        }
	        	
	        else
	        {
	        	
	        	mapcapabilities.replace(e.getId(), oldEm, e);
	        	System.out.println("replace card");
	        }
	
	}

	@Override
	public void deleteCapability(String i) {
		// TODO Auto-generated method stub
		Capability e=mapcapabilities.get(i);
		if(e!=null)
		{
			mapcapabilities.remove(e.getId());
			
		}

	}

	@Override
	public Capability getCapability(String i) {
		// TODO Auto-generated method stub
		return mapcapabilities.get(i);
	}
	

	@Override
	public List getCapabilities() {
		// TODO Auto-generated method stub
		
		System.out.println("getCapabilities()");

		List<Capability> Capabilitys=new ArrayList<Capability>();
		
		
		for(Map.Entry<String, Capability> entry:mapcapabilities.entrySet())
		{
			
			Capabilitys.add(entry.getValue());
		}
		
		return Capabilitys;
	}
}
