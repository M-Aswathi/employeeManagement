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

import com.csg.employeeManagement.model.Department;
import com.csg.employeeManagement.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

@Autowired
private DepartmentService departmentService;

@ResponseStatus(HttpStatus.CREATED)
@PostMapping
//Creates Department info
public Department create(@RequestBody Department department) {
	return departmentService.save(department);
}

//Fetches all department details from Department 
@GetMapping("/departmentDetail")
public List<Department>findAll(){
	return departmentService.findAll();
}

//Fetches department details by Department Id
@GetMapping("/id/{departmentId}")
public Department findByDepartmentId(@PathVariable Long departmentId){
	return departmentService.findByDepartmentId(departmentId);
}

//Fetches department details by DepartmentName
@GetMapping("/name/{departmentName}")
public Optional <Department> findByDepartmentName(@PathVariable String departmentName){
	return departmentService.findByDepartmentName(departmentName);
}

//Deletes the department details by department Id
@DeleteMapping("/delete/{departmentId}")
public void deleteDepartment(@PathVariable Long departmentId ){
	departmentService.deleteById(departmentId);
    	}

//Updates the department details in Department
@PutMapping("/edit")
public Department update(@RequestBody Department department){
return departmentService.updateDetail(department);
}

}