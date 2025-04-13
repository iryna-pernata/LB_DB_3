package org.example.db_lb_3.service;

import org.example.db_lb_3.models.Project;
import org.example.db_lb_3.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<Project> findAll() {
        return repository.findAll();
    }

    public Project getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public Project create(Project p) {
        return repository.save(p);
    }

    public Project update(Long id, Project p) {
        return repository.findById(id).map(project -> {
            project.setName(p.getName());
            project.setDescription(p.getDescription());
            project.setEmployees(p.getEmployees());
            return repository.save(project);
        }).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

