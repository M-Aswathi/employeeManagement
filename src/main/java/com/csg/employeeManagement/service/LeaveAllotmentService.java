package com.csg.employeeManagement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.csg.employeeManagement.model.Employee;
import com.csg.employeeManagement.model.LeaveAllotment;
import com.csg.employeeManagement.model.LeaveType;
import com.csg.employeeManagement.repository.EmployeeRepository;
import com.csg.employeeManagement.repository.LeaveAllotmentRepository;

@Service
public class LeaveAllotmentService {
@Lazy
	@Autowired
private LeaveAllotmentRepository leaveAllotmentRepository;
	
	@Autowired
private LeaveTypeService leaveTypeService;
	
	@Autowired
private EmployeeRepository employeeRepository;
	
	public void save(Long employeeId, String gender) {
	    ArrayList<LeaveAllotment> leaveAllotments = new ArrayList<>();

	    // Fetch all leaveTypes from the leaveTypeService
	    List<LeaveType> leaveTypes = leaveTypeService.findAll();
	    Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
	    
	    // Get joined date and current date
	    LocalDate joinedDate = employee.getJoinedDate();
	    //LocalDate currentDate = LocalDate.now();

	    // For loop to create the leave allotments
	    for (LeaveType leaveType : leaveTypes) {
	        LeaveAllotment leaveAllotment = new LeaveAllotment();
	        leaveAllotment.setEmployee(employee);
	        leaveAllotment.setLeaveType(leaveType);

	        // Fetch default days from LeaveType
	        int allotedDays = leaveType.getDefaultDays(); 
	        int remainingDays = 0;

	        // Calculate remaining days based on leave type ID
	        switch (leaveType.getLeaveTypeId()) {
	            case 1: // Sick Leave
	     	      remainingDays= 12 -joinedDate.getMonthValue();
	     	       break;
	            case 2: // Casual Leave
	     	       remainingDays= 12 -joinedDate.getMonthValue();
	     	       break;
	            case 5: // Vacation Leave
	                int totalMonths=12- joinedDate.getMonthValue();
	                remainingDays=totalMonths*2;
	                
	                break;

	            case 3: // Maternity Leave
	            	if(gender.equalsIgnoreCase("Female")) {
	            		remainingDays=allotedDays;
	            	}
	            	else {
	            		remainingDays=0;
	            	}
	                break;

	            case 4: // Paternity Leave
	            	if(gender.equalsIgnoreCase("Male")) {
	            		remainingDays=allotedDays;
	            	}
	            	else {
	            		remainingDays=0;
	            	}
	            	break;

	            default:
	                remainingDays = 0;
	                break;
	        }
	        
	        
	        leaveAllotment.setAllotedDays(allotedDays);
	        leaveAllotment.setRemainingDays(remainingDays);
	        leaveAllotment.setCreatedDate(LocalDate.now());
	        leaveAllotment.setUpdatedDate(leaveAllotment.getCreatedDate());
	        leaveAllotments.add(leaveAllotment);
	    }

	    leaveAllotmentRepository.saveAll(leaveAllotments);
	}
	
	 public LeaveAllotment getLeaveAllotment(Employee employee, LeaveType leaveType) {
     	return leaveAllotmentRepository.findByEmployeeAndLeaveType(employee, leaveType);
	 }
	 
	 	public LeaveAllotment save(LeaveAllotment leaveAllotment) {
	 		return leaveAllotmentRepository.save(leaveAllotment);
	 	}
}
