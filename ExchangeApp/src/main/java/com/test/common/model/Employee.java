package com.test.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {  
	
	
private int id;  
private String name;  
private int age;
private int salary;



/**
 * @return the id
 */
@Id
@GeneratedValue
@Column(name = "ID")
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the age
 */
public int getAge() {
	return age;
}
/**
 * @param age the age to set
 */
public void setAge(int age) {
	this.age = age;
}
/**
 * @return the salary
 */
public int getSalary() {
	return salary;
}
/**
 * @param salary the salary to set
 */
public void setSalary(int salary) {
	this.salary = salary;
}  
  
//getters and setters  


  
}  
