package org.groept.cloudMigration.dao;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.Court;
import org.springframework.data.repository.CrudRepository;

public interface CourtDao extends CrudRepository<Court, Long> {

	Court findById(ObjectId id);
	Court findByname(String name);
}
