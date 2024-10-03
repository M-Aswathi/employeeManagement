package com.csg.employeeManagement.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="leaveType")
public class LeaveType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="leave_type_id")
private int leaveTypeId;
private String typeDescription;
private int defaultDays;

public LeaveType() {

}

public LeaveType(int leaveTypeId, String typeDescription, int defaultDays) {
	super();
	this.leaveTypeId = leaveTypeId;
	this.typeDescription = typeDescription;
	this.defaultDays = defaultDays;
}

public int getLeaveTypeId() {
	return leaveTypeId;
}

public void setLeaveTypeId(int leaveTypeId) {
	this.leaveTypeId = leaveTypeId;
}

public String getTypeDescription() {
	return typeDescription;
}

public void setTypeDescription(String typeDescription) {
	this.typeDescription = typeDescription;
}

public int getDefaultDays() {
	return defaultDays;
}

public void setDefaultDays(int defaultDays) {
	this.defaultDays = defaultDays;
}

@Override
public int hashCode() {
	return Objects.hash(defaultDays, leaveTypeId, typeDescription);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	LeaveType other = (LeaveType) obj;
	return defaultDays == other.defaultDays && leaveTypeId == other.leaveTypeId
			&& Objects.equals(typeDescription, other.typeDescription);
}

@Override
public String toString() {
	return "LeaveType [leaveTypeId=" + leaveTypeId + ", typeDescription=" + typeDescription + ", defaultDays="
			+ defaultDays + "]";
}




}
