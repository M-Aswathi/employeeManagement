package com.csg.employeeManagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csg.employeeManagement.dao.LeaveRequestDao;
import com.csg.employeeManagement.model.Employee;
import com.csg.employeeManagement.model.LeaveAllotment;
import com.csg.employeeManagement.model.LeaveRequest;
import com.csg.employeeManagement.model.LeaveType;
import com.csg.employeeManagement.repository.LeaveRequestRepository;

@Service
public class LeaveRequestService {

	@Autowired
	private LeaveTypeService leaveTypeService;
	
	@Autowired
	private LeaveRequestRepository leaveRequestRepository;
	
	@Autowired
	private LeaveAllotmentService leaveAllotmentService;

	
	@Autowired
	private EmployeeService employeeService;
	
	public LeaveRequest saveLeaveRequest(LeaveRequestDao leaveRequestDao) throws Exception {
		
		LocalDate fromDate=leaveRequestDao.getFromDate();
		LocalDate toDate=leaveRequestDao.getToDate();
		
        long totalRequestedDays = (fromDate.getDayOfYear() - toDate.getDayOfYear());

        Long employeeId = leaveRequestDao.getEmployeeId();

        // Fetch leave type 
        LeaveType leaveType = leaveTypeService.findByLeaveTypeId(leaveRequestDao.getLeaveTypeId());
        
        Employee employee=employeeService.findById(employeeId).orElse(null);
        //Fetch from service in leaveAllotment
        LeaveAllotment leaveAllotment = leaveAllotmentService.getLeaveAllotment(employee, leaveType);


        int remainingDays=0;
        if (leaveAllotment != null) {
            remainingDays = leaveAllotment.getRemainingDays();
        } else {
            remainingDays = 0; // No leave allotment found
        }

        // Check if requested days exceed remaining days
       if (totalRequestedDays > remainingDays) {
            throw new Exception("Number of Requested days are more than Remaining Days");
        } 	
        
		LeaveRequest leaveRequest=new LeaveRequest();
		leaveRequest.setEmployeeId(leaveRequestDao.getEmployeeId());
		leaveRequest.setAppliedDate(leaveRequestDao.getAppliedDate());
		leaveRequest.setStatus(leaveRequestDao.getStatus());
		leaveRequest.setReportingOfficer(leaveRequestDao.getReportingOfficer());
		leaveRequest.setToDate(leaveRequestDao.getToDate());
		leaveRequest.setFromDate(leaveRequestDao.getFromDate());
		leaveRequest.setProcessedDate(leaveRequestDao.getProcessedDate());

		leaveRequest.setLeaveType(leaveTypeService.findByLeaveTypeId(leaveRequestDao.getLeaveTypeId()));	
		return leaveRequestRepository.save(leaveRequest);
	}
	


	public Optional<LeaveRequest> getRequestDetails(Long requestId){
		return leaveRequestRepository.findByRequestId(requestId);
	}
	
	public List<LeaveRequest> findByEmployeeId(Long employeeId){
		return leaveRequestRepository.findByEmployeeId(employeeId);
	}
	
	
	public LeaveRequest updateRequest(LeaveRequest leaveRequest) {
		LeaveRequest request=leaveRequestRepository.findByRequestId(leaveRequest.getRequestId()).orElse(null);
		request.setStatus(leaveRequest.getStatus());
		
	    if ("Approved".equalsIgnoreCase(request.getStatus())) {
			Employee employee=employeeService.findById(request.getEmployeeId()).orElse(null);
		LeaveType leaveType=leaveTypeService.findByLeaveTypeId(request.getLeaveType().getLeaveTypeId());
		
		if(employee!=null && leaveType !=null) {
			throw new RuntimeException("Employee or LeaveTypeId is not Found");
		}
			LeaveAllotment leaveAllotment= leaveAllotmentService.getLeaveAllotment(employee, leaveType);
			
			if(leaveAllotment!=null) {
				int totalLeaveDays=(request.getFromDate().getMonthValue()+ request.getToDate().getMonthValue());
				// 	     	      remainingDays= 12 -joinedDate.getMonthValue();
				
				leaveAllotment.setRemainingDays(leaveAllotment.getRemainingDays() - totalLeaveDays);
				leaveAllotmentService.save(leaveAllotment);
			}
			else {
				throw new RuntimeException("LeaveAllotment not found for the employeeid and the leavetype");
			}
		}
		
		return leaveRequestRepository.save(request);
	}
}
	