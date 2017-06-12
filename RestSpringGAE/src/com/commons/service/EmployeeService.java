package com.commons.service;

import java.util.List;

import com.commons.model.EmployeeModel;

public interface EmployeeService {

	public void saveEmployeeModel(EmployeeModel employeeModel);
	
	public void saveAllEmployeeModel(List<EmployeeModel> employeeModel);
	
	public List<EmployeeModel> viewEmployee();
	
	public EmployeeModel getEmployeeById(int id);

	public EmployeeModel getEmployeeByEmail(String email);

	public void deleteUser(int userid);
	
	public void deleteAll();
	
	public List<EmployeeModel> getActive();
	
	public List<EmployeeModel> getDeactive();

	

}
