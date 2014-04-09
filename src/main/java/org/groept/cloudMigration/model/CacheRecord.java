package org.groept.cloudMigration.model;


import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CacheRecord {
	
	@Id
	private ObjectId id;
	private int pageQuery;
	private int dbQuery;

	private Date pageRequestTime;
	
	public CacheRecord() {
		
		// TODO Auto-generated constructor stub
	}

	public CacheRecord(int pageQuery, int dbQuery, Date pageRequestTime) {
	
		this.pageQuery = pageQuery;
		this.dbQuery = dbQuery;
		this.pageRequestTime = pageRequestTime;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public int getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(int pageQuery) {
		this.pageQuery = pageQuery;
	}

	public int getDbQuery() {
		return dbQuery;
	}

	public void setDbQuery(int dbQuery) {
		this.dbQuery = dbQuery;
	}

	public Date getPageRequestTime() {
		return pageRequestTime;
	}

	public void setPageRequestTime(Date pageRequestTime) {
		this.pageRequestTime = pageRequestTime;
	}

		

}
