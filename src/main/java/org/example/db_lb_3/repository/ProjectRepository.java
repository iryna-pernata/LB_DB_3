package org.example.db_lb_3.repository;

import org.example.db_lb_3.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    // JPQL
    @Query("SELECT p FROM Project p WHERE SIZE(p.employees) >= :minEmployees")
    List<Project> findProjectsWithAtLeastEmployees(@Param("minEmployees") int minEmployees);

}

