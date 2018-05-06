package ch.juventus.example;

import ch.juventus.example.data.Department;
import ch.juventus.example.data.DepartmentRepository;
import ch.juventus.example.data.Employee;
import ch.juventus.example.data.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}

    @Component
    class initRepositoryCLR implements CommandLineRunner {

        private final EmployeeRepository employeeRepository;
        private final DepartmentRepository departmentRepository;

        @Autowired
        public initRepositoryCLR(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
            this.employeeRepository = employeeRepository;
            this.departmentRepository = departmentRepository;
        }

        @Override
        public void run(String... strings) throws Exception {
            Department accounting = new Department("Accounting");
            accounting.addEmployee(new Employee("Tim", "Taylor"));
            accounting.addEmployee(new Employee("Al", "Borland"));
            accounting.addEmployee(new Employee("Wilson", "Wilson"));
            accounting.addEmployee(new Employee("Bob", "Vila"));
            departmentRepository.save(accounting);
        }
    }


}
