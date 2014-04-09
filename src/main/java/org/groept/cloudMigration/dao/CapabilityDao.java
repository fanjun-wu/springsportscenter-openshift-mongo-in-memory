package org.groept.cloudMigration.dao;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.Capability;
import org.springframework.data.repository.CrudRepository;

public interface CapabilityDao extends CrudRepository<Capability, Long>  {

	Capability findById(ObjectId id);
}
