package com.csg.employeeManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.csg.employeeManagement.dao.LeaveRequestDao;
import com.csg.employeeManagement.model.LeaveRequest;
import com.csg.employeeManagement.service.LeaveRequestService;

@RestController
@RequestMapping("/leaveRequest")
public class LeaveRequestController {

@Autowired
private LeaveRequestService leaveRequestService;

@ResponseStatus(HttpStatus.CREATED)
@PostMapping

//Creates a new LeaveRequest
public LeaveRequest createLeaveApplication(@RequestBody LeaveRequestDao leaveRequestDao) throws Exception {
	return leaveRequestService.saveLeaveRequest(leaveRequestDao);
}

//Fetches LeaveRequest details by leaveRequest Id.
@GetMapping("/requestId/{requestId}")
	public Optional<LeaveRequest> getLeaveRequestDetails(@PathVariable Long requestId){
	return leaveRequestService.getRequestDetails(requestId);
}

@GetMapping("/requestFromEmployee/{id}")
	public List<LeaveRequest> findByEmployeeId(@PathVariable Long id){
		return leaveRequestService.findByEmployeeId(id);
}

//Updates leave request information
@PutMapping("/leaveRequestUpdate")
public LeaveRequest updateRequest(@RequestBody LeaveRequest leaveRequest){
	return leaveRequestService.updateRequest(leaveRequest);
}
}
