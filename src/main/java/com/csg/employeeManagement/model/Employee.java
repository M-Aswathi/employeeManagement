package com.csg.employeeManagement.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

private String employeeName;
private String gender;
private String designation;
private Double experience;
private LocalDate joinedDate;
private String emailId;
private String phoneNumber;
private Double salary;
@Column(columnDefinition="boolean Default true")
private Boolean isActive;


@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="department_id", referencedColumnName="department_id")
private Department department;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="manager_id")
@JsonBackReference
private Employee manager;

public Employee() {
	
}

public Employee(Long id, String employeeName, String gender, String designation, Double experience,
		LocalDate joinedDate, String emailId, String phoneNumber, Double salary, Boolean isActive,
		Department department, Employee manager) {
	super();
	this.id = id;
	this.employeeName = employeeName;
	this.gender = gender;
	this.designation = designation;
	this.experience = experience;
	this.joinedDate = joinedDate;
	this.emailId = emailId;
	this.phoneNumber = phoneNumber;
	this.salary = salary;
	this.isActive = isActive;
	this.department = department;
	this.manager = manager;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getEmployeeName() {
	return employeeName;
}

public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

public Double getExperience() {
	return experience;
}

public void setExperience(Double experience) {
	this.experience = experience;
}

public LocalDate getJoinedDate() {
	return joinedDate;
}

public void setJoinedDate(LocalDate joinedDate) {
	this.joinedDate = joinedDate;
}

public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public Double getSalary() {
	return salary;
}

public void setSalary(Double salary) {
	this.salary = salary;
}

public Boolean getIsActive() {
	return isActive;
}

public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
}

public Department getDepartment() {
	return department;
}

public void setDepartment(Department department) {
	this.department = department;
}

public Employee getManager() {
	return manager;
}

public void setManager(Employee manager) {
	this.manager = manager;
}

@Override
public String toString() {
	return "Employee [id=" + id + ", employeeName=" + employeeName + ", gender=" + gender + ", designation="
			+ designation + ", experience=" + experience + ", joinedDate=" + joinedDate + ", emailId=" + emailId
			+ ", phoneNumber=" + phoneNumber + ", salary=" + salary + ", isActive=" + isActive + ", department="
			+ department + ", manager=" + manager + "]";
}

@Override
public int hashCode() {
	return Objects.hash(department, designation, emailId, employeeName, experience, gender, id, isActive, joinedDate,
			manager, phoneNumber, salary);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	return Objects.equals(department, other.department) && Objects.equals(designation, other.designation)
			&& Objects.equals(emailId, other.emailId) && Objects.equals(employeeName, other.employeeName)
			&& Objects.equals(experience, other.experience) && Objects.equals(gender, other.gender)
			&& Objects.equals(id, other.id) && Objects.equals(isActive, other.isActive)
			&& Objects.equals(joinedDate, other.joinedDate) && Objects.equals(manager, other.manager)
			&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(salary, other.salary);
}






}
