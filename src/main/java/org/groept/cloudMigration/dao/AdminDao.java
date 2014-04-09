package org.groept.cloudMigration.dao;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminDao extends CrudRepository<Admin, Long> {
	Admin findById(ObjectId id);
	
	
}
