package org.groept.cloudMigration.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.groept.cloudMigration.model.TimeInterval;


public interface TimeIntervalService {

	public void saveTimeInterval(TimeInterval timeInterval);
	public void editTimeInterval(TimeInterval timeInterval);
	public void deleteTimeInterval(String timeIntervalId);
	public TimeInterval getTimeInterval(String timeIntervalId);
	public List getTimeIntervals();
	
	void saveTimeSet(Set<TimeInterval> tals);
	public List getTimeIntervalByDate(Date date);
}
