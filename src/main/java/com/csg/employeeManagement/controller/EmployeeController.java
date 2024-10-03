package com.csg.employeeManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.csg.employeeManagement.dao.EmployeeDao;
import com.csg.employeeManagement.model.Employee;
import com.csg.employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

@Autowired
private EmployeeService employeeService;


//Creates Employee info
@ResponseStatus(HttpStatus.CREATED)
@PostMapping					
public Employee create(@RequestBody EmployeeDao employeeDao) {
	return employeeService.save(employeeDao);
}


//Fetches Employee details by Employee id
@GetMapping("/id/{id}")
public Optional<Employee> findByEmployeeId(Long id){
	return employeeService.findById(id);
}

//Deleting Employee details by EmployeeId
@DeleteMapping("/delete/{id}")
public void deleteById(@PathVariable Long id) {
	employeeService.deleteById(id); 
}

//Fetch all the Employee details
@GetMapping("/all")
public List<Employee> findAll(){
	return employeeService.findAll();
}

//Fetch Employee details through managerId
@GetMapping("/manager/{managerId}")
public List<Employee> findByManagerId(@PathVariable Long managerId){
	return employeeService.findByManagerId(managerId);
}

//Updating the Employee detail
@PutMapping("/update")
public Employee updateEmployee(@RequestBody EmployeeDao employeeDao) {
	return employeeService.save(employeeDao);
}

}

