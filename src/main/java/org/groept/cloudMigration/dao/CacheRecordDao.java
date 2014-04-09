package org.groept.cloudMigration.dao;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.CacheRecord;
import org.springframework.data.repository.CrudRepository;

public interface CacheRecordDao extends CrudRepository<CacheRecord, Long>  {
	
	public CacheRecord findById(ObjectId id);
	

}
