package com.csg.employeeManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csg.employeeManagement.model.LeaveRequest;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest,Long> {
		
public Optional<LeaveRequest> findByRequestId(Long requestId);

List<LeaveRequest> findByEmployeeId(Long id);

}
