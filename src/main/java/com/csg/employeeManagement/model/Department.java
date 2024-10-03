package com.csg.employeeManagement.model;

import java.util.Objects;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="department_id")
private Long departmentId;
private String departmentName;
private Long totalNumberOfEmployees;
@Column(columnDefinition="boolean Default true ")
private Boolean isActive;

public Department() {
}

public Department(Long departmentId, String departmentName, Long totalNumberOfEmployees, Boolean isActive) {
	super();
	this.departmentId = departmentId;
	this.departmentName = departmentName;
	this.totalNumberOfEmployees = totalNumberOfEmployees;
	this.isActive = isActive;
}

public Long getDepartmentId() {
	return departmentId;
}

public void setDepartmentId(Long departmentId) {
	this.departmentId = departmentId;
}

public String getDepartmentName() {
	return departmentName;
}

public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}

public Long getTotalNumberOfEmployees() {
	return totalNumberOfEmployees;
}

public void setTotalNumberOfEmployees(Long totalNumberOfEmployees) {
	this.totalNumberOfEmployees = totalNumberOfEmployees;
}

public Boolean getIsActive() {
	return isActive;
}

public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
}

@Override
public String toString() {
	return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName
			+ ", totalNumberOfEmployees=" + totalNumberOfEmployees + ", isActive=" + isActive + "]";
}

@Override
public int hashCode() {
	return Objects.hash(departmentId, departmentName, isActive, totalNumberOfEmployees);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Department other = (Department) obj;
	return Objects.equals(departmentId, other.departmentId) && Objects.equals(departmentName, other.departmentName)
			&& Objects.equals(isActive, other.isActive)
			&& Objects.equals(totalNumberOfEmployees, other.totalNumberOfEmployees);
}




}
