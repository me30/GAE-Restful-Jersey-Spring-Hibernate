package com.commons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.dao.EmployeeDao;
import com.commons.model.EmployeeModel;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void saveEmployeeModel(EmployeeModel employeeModel) {
		employeeDao.saveEmployeeModel(employeeModel);
	}
	
	@Override
	public List<EmployeeModel> viewEmployee() {
		return employeeDao.viewEmployee();
	}

	@Override
	public EmployeeModel getEmployeeById(int id) {
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public EmployeeModel getEmployeeByEmail(String email) {
		return employeeDao.getEmployeeByEmail(email);
	}

	@Override
	public void deleteUser(int id) {
		employeeDao.deleteEmployee(id);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		employeeDao.deleteAll();
	}

	@Override
	public void saveAllEmployeeModel(List<EmployeeModel> employeeModel) {
		// TODO Auto-generated method stub
		employeeDao.saveAllEmployeeModel(employeeModel);
	}

	@Override
	public List<EmployeeModel> getActive() {
		// TODO Auto-generated method stub
		return employeeDao.getActive();
	}

	@Override
	public List<EmployeeModel> getDeactive() {
		// TODO Auto-generated method stub
		return employeeDao.getDeactive();
	}


}
