package org.example.db_lb_3.repository;

import org.example.db_lb_3.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> { }
