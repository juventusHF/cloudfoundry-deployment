package ch.juventus.example.web;

import ch.juventus.example.data.Employee;
import ch.juventus.example.data.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public List<Employee> all() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee get(@PathVariable Long id) {
        return employeeRepository.getOne(id);
    }

    @PostMapping("/employees")
    public ResponseEntity<?> create(@RequestBody Employee requestEmployee) {

        Employee persistedEmployee = employeeRepository.save(requestEmployee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(persistedEmployee.getStid()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/employees/{id}")
    public void update(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setStid(id);
        employeeRepository.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable Long id) {
        employeeRepository.delete(id);
    }

}
