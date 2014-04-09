package org.groept.cloudMigration.dao;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.Hall;
import org.springframework.data.repository.CrudRepository;

public interface HallDao extends CrudRepository<Hall, Long>{
	Hall findById(ObjectId id);
}
