package org.example.db_lb_3.service;

import org.example.db_lb_3.models.Department;
import org.example.db_lb_3.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repo;

    public DepartmentService(DepartmentRepository repo) {
        this.repo = repo;
    }

    public List<Department> getAll() {
        return repo.findAll();
    }

    public Department getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public Department create(Department department) {
        return repo.save(department);
    }

    public Department update(Long id, Department updatedData) {
        return repo.findById(id).map(dep -> {
            dep.setName(updatedData.getName());
            return repo.save(dep);
        }).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
