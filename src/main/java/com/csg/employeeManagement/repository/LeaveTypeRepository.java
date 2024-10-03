package com.csg.employeeManagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csg.employeeManagement.model.LeaveType;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Integer>{

	public LeaveType findByLeaveTypeId(int leaveTypeId);
}
