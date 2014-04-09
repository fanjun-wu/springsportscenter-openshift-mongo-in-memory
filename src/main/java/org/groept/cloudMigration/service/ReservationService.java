package org.groept.cloudMigration.service;

import java.util.List;

import org.groept.cloudMigration.model.Reservation;


public interface ReservationService {

	public void saveReservation(Reservation reservation);
	public void editReservation(Reservation reservation);
	public void deleteReservation(String reservationId);
	public Reservation getReservation(String reservationId);
	public List getReservations();
	public void addTimeInterval(String tId, String rId);
}
