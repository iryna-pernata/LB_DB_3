package org.example.db_lb_3.controller;

import org.example.db_lb_3.models.Department;
import org.example.db_lb_3.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Department> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Department create(@RequestBody Department department) {
        return service.create(department);
    }

    @PutMapping("/{id}")
    public Department update(@PathVariable Long id, @RequestBody Department department) {
        return service.update(id, department);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
