package org.groept.cloudMigration.service;

import java.util.List;

import org.groept.cloudMigration.model.Admin;

public interface AdminService {
	public void saveAdmin(Admin admin);
	public void editAdmin(Admin admin);
	public void deleteAdmin(String adminId);
	public Admin getAdmin(String adminId);
	public List getAdmins();
}
