package com.csg.employeeManagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csg.employeeManagement.model.LeaveType;
import com.csg.employeeManagement.repository.LeaveTypeRepository;

@Service
public class LeaveTypeService {

@Autowired
private LeaveTypeRepository leaveTypeRepository;

public LeaveType save(LeaveType leaveType) {
	return leaveTypeRepository.save(leaveType);
}

public LeaveType findByLeaveTypeId(int leaveTypeId) {
	return leaveTypeRepository.findByLeaveTypeId(leaveTypeId);
}

public List<LeaveType> findAll(){
	return leaveTypeRepository.findAll();
}

}
