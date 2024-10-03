package com.csg.employeeManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.csg.employeeManagement.model.LeaveType;
import com.csg.employeeManagement.service.LeaveTypeService;

@RestController
@RequestMapping("/leaveType")

public class LeaveTypeController {
	
@Autowired
private LeaveTypeService leaveTypeService;

//Creates a new leave type 
@ResponseStatus(HttpStatus.CREATED)
@PostMapping
public LeaveType createType(@RequestBody LeaveType leaveType) {
	return leaveTypeService.save(leaveType);
}

//Fetches leaveType details by its id
@GetMapping("/findId/{leaveTypeId}")
public LeaveType typeId(@PathVariable int leaveTypeId){
	return leaveTypeService.findByLeaveTypeId(leaveTypeId);
}


//Fetch all leaveType
@GetMapping("/fetch")
public List<LeaveType> fetchAll(){
	return leaveTypeService.findAll();
}

}
