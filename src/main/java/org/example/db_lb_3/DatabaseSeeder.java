package org.example.db_lb_3;

import org.example.db_lb_3.models.Department;
import org.example.db_lb_3.models.Employee;
import org.example.db_lb_3.models.Project;
import org.example.db_lb_3.repository.DepartmentRepository;
import org.example.db_lb_3.repository.EmployeeRepository;
import org.example.db_lb_3.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public DatabaseSeeder(DepartmentRepository departmentRepository,
                          EmployeeRepository employeeRepository,
                          ProjectRepository projectRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (departmentRepository.count() == 0) {
            Department dev = new Department("Web Development");
            Department support = new Department("Tech Support");
            departmentRepository.saveAll(List.of(dev, support));

            if (employeeRepository.count() == 0) {
                Employee e1 = new Employee("Anna", dev);
                Employee e2 = new Employee("Mark", dev);
                Employee e3 = new Employee("Julia", support);
                employeeRepository.saveAll(List.of(e1, e2, e3));

                if (projectRepository.count() == 0) {
                    Project p1 = new Project("CRM System", "Development of a customer CRM platform");
                    Project p2 = new Project("Helpdesk Portal", "Internal support system");

                    // призначаємо співробітників до проєктів
                    p1.getEmployees().addAll(List.of(e1, e2));
                    p2.getEmployees().add(e3);

                    projectRepository.saveAll(List.of(p1, p2));
                }
            }
        }

        System.out.println(" IT-проекти та співробітники додані до бази даних.");
    }
}

