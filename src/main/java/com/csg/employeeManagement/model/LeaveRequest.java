package com.csg.employeeManagement.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="leaveRequest")
public class LeaveRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

private Long requestId;
private Long employeeId;
private String reportingOfficer;
private LocalDate fromDate;
private LocalDate toDate;										
private String status;
private LocalDate appliedDate;
private LocalDate processedDate;


@OneToOne
@JoinColumn(name="leave_type_id", referencedColumnName="leave_type_id")
private LeaveType leaveType;

public LeaveRequest() {

}

public LeaveRequest(Long requestId, Long employeeId, String reportingOfficer, LocalDate fromDate, LocalDate toDate,
		String status, LocalDate appliedDate, LocalDate processedDate, LeaveType leaveType) {
	super();
	this.requestId = requestId;
	this.employeeId = employeeId;
	this.reportingOfficer = reportingOfficer;
	this.fromDate = fromDate;
	this.toDate = toDate;
	this.status = status;
	this.appliedDate = appliedDate;
	this.processedDate = processedDate;
	this.leaveType = leaveType;
}

public Long getRequestId() {
	return requestId;
}

public void setRequestId(Long requestId) {
	this.requestId = requestId;
}

public Long getEmployeeId() {
	return employeeId;
}

public void setEmployeeId(Long employeeId) {
	this.employeeId = employeeId;
}

public String getReportingOfficer() {
	return reportingOfficer;
}

public void setReportingOfficer(String reportingOfficer) {
	this.reportingOfficer = reportingOfficer;
}

public LocalDate getFromDate() {
	return fromDate;
}

public void setFromDate(LocalDate fromDate) {
	this.fromDate = fromDate;
}

public LocalDate getToDate() {
	return toDate;
}

public void setToDate(LocalDate toDate) {
	this.toDate = toDate;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public LocalDate getAppliedDate() {
	return appliedDate;
}

public void setAppliedDate(LocalDate appliedDate) {
	this.appliedDate = appliedDate;
}

public LocalDate getProcessedDate() {
	return processedDate;
}

public void setProcessedDate(LocalDate processedDate) {
	this.processedDate = processedDate;
}

public LeaveType getLeaveType() {
	return leaveType;
}

public void setLeaveType(LeaveType leaveType) {
	this.leaveType = leaveType;
}

@Override
public String toString() {
	return "LeaveRequest [requestId=" + requestId + ", employeeId=" + employeeId + ", reportingOfficer="
			+ reportingOfficer + ", fromDate=" + fromDate + ", toDate=" + toDate + ", status=" + status
			+ ", appliedDate=" + appliedDate + ", processedDate=" + processedDate + ", leaveType=" + leaveType + "]";
}

@Override
public int hashCode() {
	return Objects.hash(appliedDate, employeeId, fromDate, leaveType, processedDate, reportingOfficer, requestId,
			status, toDate);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	LeaveRequest other = (LeaveRequest) obj;
	return Objects.equals(appliedDate, other.appliedDate) && Objects.equals(employeeId, other.employeeId)
			&& Objects.equals(fromDate, other.fromDate) && Objects.equals(leaveType, other.leaveType)
			&& Objects.equals(processedDate, other.processedDate)
			&& Objects.equals(reportingOfficer, other.reportingOfficer) && Objects.equals(requestId, other.requestId)
			&& Objects.equals(status, other.status) && Objects.equals(toDate, other.toDate);
}


}
