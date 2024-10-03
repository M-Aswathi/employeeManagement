package com.csg.employeeManagement.dao;

public class LeaveAllotmentDao {

	private Long allotedDays;
	private Long remainingDays;
	private Long employeeId;
	private Long LeaveTypeId;
	
	
	public LeaveAllotmentDao() {

	}


	public Long getAllotedDays() {
		return allotedDays;
	}


	public void setAllotedDays(Long allotedDays) {
		this.allotedDays = allotedDays;
	}


	public Long getRemainingDays() {
		return remainingDays;
	}


	public void setRemainingDays(Long remainingDays) {
		this.remainingDays = remainingDays;
	}


	public Long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}


	public Long getLeaveTypeId() {
		return LeaveTypeId;
	}


	public void setLeaveTypeId(Long leaveTypeId) {
		LeaveTypeId = leaveTypeId;
	}


	


	


}
