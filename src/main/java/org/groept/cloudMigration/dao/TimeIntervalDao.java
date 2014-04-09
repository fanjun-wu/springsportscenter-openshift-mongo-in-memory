package org.groept.cloudMigration.dao;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.TimeInterval;
import org.springframework.data.repository.CrudRepository;

public interface TimeIntervalDao extends CrudRepository<TimeInterval, Long>{
	TimeInterval findById(ObjectId id);
}
