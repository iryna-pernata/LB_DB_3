package org.example.db_lb_3.repository;

import org.example.db_lb_3.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> { }