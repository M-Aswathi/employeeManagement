package com.csg.employeeManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csg.employeeManagement.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

List<Department> findAll();

Optional<Department> findByDepartmentId(Long departmentId);

Optional<Department> findByDepartmentName(String departmentName);

void deleteById(Long id);

}
