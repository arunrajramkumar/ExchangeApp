package com.xyz.common.dao;

import java.util.List;

import com.xyz.common.model.Employee;

public interface EmployeeDAO {

	public List<Employee> list();
    
    public Employee get(int id);
     
    public void saveOrUpdate(Employee user);
     
    public void delete(int id);
	
}
