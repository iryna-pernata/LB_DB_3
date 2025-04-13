package org.example.db_lb_3.service;

import org.example.db_lb_3.models.Employee;
import org.example.db_lb_3.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee create(Employee employee) {
        return repo.save(employee);
    }

    public Employee update(Long id, Employee updatedData) {
        return repo.findById(id).map(emp -> {
            emp.setName(updatedData.getName());
            emp.setDepartment(updatedData.getDepartment());
            return repo.save(emp);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

