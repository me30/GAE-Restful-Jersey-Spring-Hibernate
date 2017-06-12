package com.commons.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	private String designation;
	private String status;
	
	
	
	public EmployeeModel() {
	}
	
	
	public EmployeeModel(int id, String name, String designation, String status) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.status = status;
	}

	

	public EmployeeModel(String name, String designation, String status) {
		
		this.name = name;
		this.designation = designation;
		this.status = status;
	}
	
	public EmployeeModel(int id) {
		
		this.id=id;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
