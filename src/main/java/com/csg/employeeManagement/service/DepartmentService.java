package com.csg.employeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csg.employeeManagement.model.Department;
import com.csg.employeeManagement.repository.DepartmentRepository;

@Service
public class DepartmentService {

@Autowired
private DepartmentRepository departmentRepository;

public Department save(Department department) {
	department.setIsActive(true);
	return departmentRepository.save(department);
}

public List<Department> findAll(){
	return departmentRepository.findAll();
}

public Department findByDepartmentId(Long departmentId){
	return departmentRepository.findByDepartmentId(departmentId).orElse(null);

}

public Optional<Department> findByDepartmentName(String departmentName){
	return departmentRepository.findByDepartmentName(departmentName);
}

public void deleteById(Long departmentId) {
    Department department=findByDepartmentId(departmentId);
    department.setIsActive(false);
    departmentRepository.save(department);
}

public Department updateDetail(Department department){
	Department currentDepartment =departmentRepository.findByDepartmentId(department.getDepartmentId()).orElse(null);
currentDepartment.setDepartmentName(department.getDepartmentName());
currentDepartment.setIsActive(department.getIsActive());
currentDepartment.setTotalNumberOfEmployees(department.getTotalNumberOfEmployees());

	return departmentRepository.save(currentDepartment);
	
}
}
