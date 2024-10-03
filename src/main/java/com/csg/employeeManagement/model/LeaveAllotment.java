package com.csg.employeeManagement.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="leaveAllotment")

public class LeaveAllotment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long allotmentId;
private int allotedDays;
private int remainingDays;
private LocalDate createdDate;
private LocalDate updatedDate;


@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="employee_id", referencedColumnName="id" )
private Employee employee;

@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="leave_type_id", referencedColumnName="leave_type_id")
private LeaveType leaveType;

public LeaveAllotment() {

}

public LeaveAllotment(Long allotmentId, int allotedDays, int remainingDays, LocalDate createdDate,
		LocalDate updatedDate, Employee employee, LeaveType leaveType) {
	super();
	this.allotmentId = allotmentId;
	this.allotedDays = allotedDays;
	this.remainingDays = remainingDays;
	this.createdDate = createdDate;
	this.updatedDate = updatedDate;
	this.employee = employee;
	this.leaveType = leaveType;
}

public Long getAllotmentId() {
	return allotmentId;
}

public void setAllotmentId(Long allotmentId) {
	this.allotmentId = allotmentId;
}

public int getAllotedDays() {
	return allotedDays;
}

public void setAllotedDays(int allotedDays) {
	this.allotedDays = allotedDays;
}

public int getRemainingDays() {
	return remainingDays;
}

public void setRemainingDays(int remainingDays) {
	this.remainingDays = remainingDays;
}

public LocalDate getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(LocalDate createdDate) {
	this.createdDate = createdDate;
}

public LocalDate getUpdatedDate() {
	return updatedDate;
}

public void setUpdatedDate(LocalDate updatedDate) {
	this.updatedDate = updatedDate;
}

public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}

public LeaveType getLeaveType() {
	return leaveType;
}

public void setLeaveType(LeaveType leaveType) {
	this.leaveType = leaveType;
}

@Override
public String toString() {
	return "LeaveAllotment [allotmentId=" + allotmentId + ", allotedDays=" + allotedDays + ", remainingDays="
			+ remainingDays + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", employee=" + employee
			+ ", leaveType=" + leaveType + "]";
}

@Override
public int hashCode() {
	return Objects.hash(allotedDays, allotmentId, createdDate, employee, leaveType, remainingDays, updatedDate);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	LeaveAllotment other = (LeaveAllotment) obj;
	return allotedDays == other.allotedDays && Objects.equals(allotmentId, other.allotmentId)
			&& Objects.equals(createdDate, other.createdDate) && Objects.equals(employee, other.employee)
			&& Objects.equals(leaveType, other.leaveType) && remainingDays == other.remainingDays
			&& Objects.equals(updatedDate, other.updatedDate);
}


}
