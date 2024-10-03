package com.csg.employeeManagement.dao;

import java.time.LocalDate;

public class LeaveRequestDao {

	private Long employeeId;
	private String reportingOfficer;
	private LocalDate fromDate;
	private LocalDate toDate;										
	private String status;
	private LocalDate appliedDate;
	private LocalDate processedDate;
	private int leaveTypeId;
	
	public LeaveRequestDao() {

	}

	public LeaveRequestDao(Long employeeId, String reportingOfficer, LocalDate fromDate, LocalDate toDate,
			String status, LocalDate appliedDate, LocalDate processedDate, int leaveTypeId) {
		super();
		this.employeeId = employeeId;
		this.reportingOfficer = reportingOfficer;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.status = status;
		this.appliedDate = appliedDate;
		this.processedDate = processedDate;
		this.leaveTypeId = leaveTypeId;
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

	public int getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	
	
	
	
	
}
