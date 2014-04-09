package org.groept.cloudMigration.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import org.groept.cloudMigration.model.Admin;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.service.AdminService;
import org.groept.cloudMigration.service.CacheRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
		
	
	private ConcurrentMap<String, Admin> mapadmins=(ConcurrentMap)(new ClassPathXmlApplicationContext("hazelcast.xml").getBean("adminmap"));
	
	
	@Override
	public void saveAdmin(Admin e) {
		// TODO Auto-generated method stub
		 Admin oldEm=mapadmins.get(e.getId());
	        if(oldEm==null)
	        {
	        	mapadmins.put(e.getId(), e);
	        	System.out.println("new card");
	        	
	        }
	        	
	        else
	        {
	        	
	        	mapadmins.replace(e.getId(), oldEm, e);
	        	System.out.println("replace card");
	        }
	
	}
	@Override
	public void editAdmin(Admin e) {
		// TODO Auto-generated method stub
		 Admin oldEm=mapadmins.get(e.getId());
	        if(oldEm==null)
	        {
	        	mapadmins.put(e.getId(), e);
	        	System.out.println("new card");
	        	
	        }
	        	
	        else
	        {
	        	
	        	mapadmins.replace(e.getId(), oldEm, e);
	        	System.out.println("replace card");
	        }
		
	}

	@Override
	public void deleteAdmin(String i) {
		// TODO Auto-generated method stub
		
		Admin e=mapadmins.get(i);
		if(e!=null)
		{
			mapadmins.remove(e.getId());
			
		}

	}

	@Override
	public Admin getAdmin(String i) {
		// TODO Auto-generated method stub
		return mapadmins.get(i);	
	}
	

	@Override
	public List getAdmins() {
		// TODO Auto-generated method stub
		
		List<Admin> Admins=new ArrayList<Admin>();
		
		
		for(Map.Entry<String, Admin> entry:mapadmins.entrySet())
		{
			
			Admins.add(entry.getValue());
		}
		
		return Admins;

	}

	
}
