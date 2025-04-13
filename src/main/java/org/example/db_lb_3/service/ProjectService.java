package org.example.db_lb_3.service;

import org.example.db_lb_3.models.Project;
import org.example.db_lb_3.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repo;

    public ProjectService(ProjectRepository repo) {
        this.repo = repo;
    }

    public List<Project> getAll() {
        return repo.findAll();
    }

    public Project getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public Project create(Project project) {
        return repo.save(project);
    }

    public Project update(Long id, Project updatedData) {
        return repo.findById(id).map(proj -> {
            proj.setTitle(updatedData.getTitle());
            proj.setBudget(updatedData.getBudget());
            proj.setEmployees(updatedData.getEmployees());
            return repo.save(proj);
        }).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

