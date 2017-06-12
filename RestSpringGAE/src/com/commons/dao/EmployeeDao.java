package com.commons.dao;

import java.util.List;

import com.commons.model.EmployeeModel;

public interface EmployeeDao {

	public void saveEmployeeModel(EmployeeModel employeeModel);
	
	public void saveAllEmployeeModel(List<EmployeeModel> employeeModel);
	
	public List<EmployeeModel> viewEmployee();
	
	public EmployeeModel getEmployeeByEmail(String email);
	
	public EmployeeModel getEmployeeById(int userid);
	
	public void deleteEmployee(int id);
	
	public void deleteAll();
	
	public List<EmployeeModel> getActive();
	
	public List<EmployeeModel> getDeactive();
}
