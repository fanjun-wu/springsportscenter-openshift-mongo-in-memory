package org.groept.cloudMigration.dao;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.Subscriber;
import org.springframework.data.repository.CrudRepository;

public interface SubscriberDao extends CrudRepository<Subscriber, Long> {
	Subscriber findById(ObjectId id);
}
