package com.csg.employeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.csg.employeeManagement.service.LeaveAllotmentService;

@RestController
@RequestMapping("/leaveAllotment")
public class LeaveAllotmentController {

	@Autowired
private LeaveAllotmentService leaveAllotmentService;
	
@ResponseStatus(HttpStatus.CREATED)
@PostMapping

//Creates LeaveAllotment
public void createAllotment(@RequestBody Long employeeId, @RequestBody String gender) {
 leaveAllotmentService.save(employeeId, gender);
}


}
