package org.groept.cloudMigration.service;

import java.util.List;

import org.groept.cloudMigration.model.Hall;


public interface HallService {
	public void saveHall(Hall hall);
	public void editHall(Hall hall);
	public void deleteHall(String hallId);
	public Hall getHall(String hallId);
	public List getHalls();
	public void addCourt(String hallId, String courtId);
	public List listofCourts(String hallId);

	
}
