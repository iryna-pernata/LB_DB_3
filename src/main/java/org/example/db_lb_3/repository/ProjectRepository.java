package org.example.db_lb_3.repository;

import org.example.db_lb_3.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> { }
