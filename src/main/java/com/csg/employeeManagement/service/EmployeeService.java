package com.csg.employeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csg.employeeManagement.dao.EmployeeDao;
import com.csg.employeeManagement.model.Employee;
import com.csg.employeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

@Autowired
private EmployeeRepository employeeRepository;

@Autowired
private DepartmentService departmentService;

@Autowired
private LeaveAllotmentService leaveAllotmentService;

public Employee save(EmployeeDao employeeDao) {
	Employee employee=new Employee();
	
	//Fetching objects from dao.ser and setting it to new object employee
	employee.setEmployeeName(employeeDao.getEmployeeName());
	employee.setGender(employeeDao.getGender());
	employee.setEmailId(employeeDao.getEmailId());
	employee.setDesignation(employeeDao.getDesignation());
	employee.setExperience(employeeDao.getExperience());
	employee.setJoinedDate(employeeDao.getJoinedDate());
	employee.setPhoneNumber(employeeDao.getPhoneNumber());
	employee.setSalary(employeeDao.getSalary());
	employee.setIsActive(true);
	
	//From Department class fetching departmentId with dao.ser object and set to new object.
	employee.setDepartment(departmentService.findByDepartmentId(employeeDao.getDepartmentId()));
	employee.setManager(findById(employeeDao.getManagerId()).orElse(null));
    employee=employeeRepository.save(employee);
   
    //passing saved id and gender to lea.allot
	leaveAllotmentService.save(employee.getId(),employee.getGender());
   return employee;
   
}


public Optional<Employee> findById(Long employeeId){
	return employeeRepository.findById(employeeId);

}


public void deleteById(Long employeeId) {
	Optional<Employee> employee=findById(employeeId);
	employee.get().setIsActive(false);
	employeeRepository.save(employee.get());

}

public List<Employee> findAll(){
	return employeeRepository.findAll();
}

public List<Employee> findByManagerId(Long managerId){
	return employeeRepository.findByManagerId(managerId);
}


public Employee update(Employee employee) {
	Employee edit=employeeRepository.findById(employee.getId()).orElse(null);
	edit.setEmployeeName(employee.getEmployeeName());
	edit.setExperience(employee.getExperience());
	edit.setDesignation(employee.getDesignation());
	edit.setJoinedDate(employee.getJoinedDate());
	edit.setPhoneNumber(employee.getPhoneNumber());
	edit.setSalary(employee.getSalary());
	edit.setEmailId(employee.getEmailId());
	edit.setIsActive(employee.getIsActive());
	return employeeRepository.save(edit);
}

}