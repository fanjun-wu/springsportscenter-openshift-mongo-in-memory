package org.groept.cloudMigration.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

import org.groept.cloudMigration.dao.TimeIntervalDao;
import org.groept.cloudMigration.model.Admin;
import org.groept.cloudMigration.model.CacheRecord;
import org.groept.cloudMigration.model.Capability;
import org.groept.cloudMigration.model.TimeInterval;
import org.groept.cloudMigration.service.CacheRecordService;
import org.groept.cloudMigration.service.TimeIntervalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class TimeIntervalServiceImpl implements TimeIntervalService {

	
	private ConcurrentMap<String, TimeInterval> maptimeintervals=(ConcurrentMap)(new ClassPathXmlApplicationContext("hazelcast.xml").getBean("timeintervalmap"));
	
	
	
	@Override
	public void saveTimeInterval(TimeInterval e) {
		// TODO Auto-generated method stub
		 TimeInterval oldEm=maptimeintervals.get(e.getId());
	        if(oldEm==null)
	        {
	        	maptimeintervals.put(e.getId(), e);
	        	System.out.println("new card");
	        	
	        }
	        	
	        else
	        {
	        	
	        	maptimeintervals.replace(e.getId(), oldEm, e);
	        	System.out.println("replace card");
	        }
	
	}
	@Override
	public void editTimeInterval(TimeInterval e) {
		// TODO Auto-generated method stub
		 TimeInterval oldEm=maptimeintervals.get(e.getId());
	        if(oldEm==null)
	        {
	        	maptimeintervals.put(e.getId(), e);
	        	System.out.println("new card");
	        	
	        }
	        	
	        else
	        {
	        	
	        	maptimeintervals.replace(e.getId(), oldEm, e);
	        	System.out.println("replace card");
	        }
	
	}

	@Override
	public void deleteTimeInterval(String i) {
		// TODO Auto-generated method stub

		TimeInterval e=maptimeintervals.get(i);
		if(e!=null)
		{
			maptimeintervals.remove(e.getId());
			
		}
	}

	@Override
	public TimeInterval getTimeInterval(String i) {
		// TODO Auto-generated method stub
		return maptimeintervals.get(i);
	}
	

	@Override
	public List getTimeIntervals() {
		// TODO Auto-generated method stub
		
		
List<TimeInterval> TimeIntervals=new ArrayList<TimeInterval>();
		
		
		for(Map.Entry<String, TimeInterval> entry:maptimeintervals.entrySet())
		{
			
			TimeIntervals.add(entry.getValue());
		}
		
		return TimeIntervals;

	}
	
	@Override
	public List getTimeIntervalByDate(Date date) {
		// TODO Auto-generated method stub
		List<TimeInterval> timeIntervalsTemp=new ArrayList<TimeInterval>();
		List<TimeInterval> timeIntervals=new ArrayList<TimeInterval>();
		timeIntervalsTemp=this.getTimeIntervals();
		for(TimeInterval t:timeIntervalsTemp)
		{
			
			if((t.getDate().getYear()==date.getYear())&&(t.getDate().getMonth()==date.getMonth())&&(t.getDate().getDay()==date.getDay()))			
//			if( t.getDate()==date)
			{
				timeIntervals.add(t);
			}
		}
		return timeIntervals;
		
		
	}
	
	@Override
	public void saveTimeSet(Set<TimeInterval> tals) {
		// TODO Auto-generated method stub
		
		for(TimeInterval t:tals)
			maptimeintervals.putIfAbsent(t.getId(),t);
		
		
	}
	
}
