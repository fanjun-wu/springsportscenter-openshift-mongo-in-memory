package org.groept.cloudMigration.service;

import java.util.List;

import org.groept.cloudMigration.model.Capability;


public interface CapabilityService {

	public void saveCapability(Capability capability);
	public void editCapability(Capability capability);
	public void deleteCapability(String capabilityId);
	public Capability getCapability(String capabilityId);
	public List getCapabilities();
}
