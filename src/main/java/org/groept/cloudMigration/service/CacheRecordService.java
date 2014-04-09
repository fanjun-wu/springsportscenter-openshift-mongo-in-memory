package org.groept.cloudMigration.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.groept.cloudMigration.model.CacheRecord;


public interface CacheRecordService {
	
	public void saveCacheRecord(CacheRecord cacheRecord);
	
	public void deleteCacheRecord(ObjectId cacheRecordId);
	public CacheRecord getCacheRecord(ObjectId adminId);
	public List getCacheRecords();
	

}
