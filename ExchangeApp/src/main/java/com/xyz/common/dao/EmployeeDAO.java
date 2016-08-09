package com.test.common.dao;

import java.util.List;

import com.test.common.model.Employee;

public interface EmployeeDAO {

	public List<Employee> list();
    
    public Employee get(int id);
     
    public void saveOrUpdate(Employee user);
     
    public void delete(int id);
	
}
