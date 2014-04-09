package org.groept.cloudMigration.dao;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationDao extends CrudRepository<Reservation, Long> {
	Reservation findById(ObjectId id);
}
