package com.csg.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csg.employeeManagement.model.Employee;
import com.csg.employeeManagement.model.LeaveAllotment;
import com.csg.employeeManagement.model.LeaveType;

@Repository
public interface LeaveAllotmentRepository extends JpaRepository<LeaveAllotment, Long> {

LeaveAllotment findByEmployeeAndLeaveType(Employee employee, LeaveType leaveType);



}
