package org.groept.cloudMigration.service;

import java.util.List;
import java.util.Set;

import org.groept.cloudMigration.model.Court;
import org.groept.cloudMigration.model.Hall;
import org.groept.cloudMigration.model.TimeInterval;


public interface CourtService{
	public void saveCourt(Court court);
	public void editCourt(Court court);
	public void deleteCourt(String courtId);
	public Court getCourt(String courtId);
	public List getCourts();
	public Hall getHall();
	public Court getCourtByName(String _nameOfCourtRecieved);
	public void saveAllCourt(Set<Court> allCourts );
}
