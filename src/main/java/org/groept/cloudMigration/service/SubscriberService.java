package org.groept.cloudMigration.service;

import java.util.List;

import org.groept.cloudMigration.model.Reservation;
import org.groept.cloudMigration.model.Subscriber;


public interface SubscriberService {

	public void saveSubscriber(Subscriber subscriber);
	public void editSubscriber(Subscriber subscriber);
	public void deleteSubscriber(String subscriberId);
	public Subscriber getSubscriber(String subscriberId);
	public List getSubscribers();
	public void addReservationtoPerson(String subscriverId, Reservation reservationId);
}
