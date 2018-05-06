package ch.juventus.example.web;

import ch.juventus.example.data.Department;
import ch.juventus.example.data.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class DepartmentController {
    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/departments")
    public List<Department> all() {
        return departmentRepository.findAll().stream()
                .map(d -> addHateoasLinks(d))
                .collect(Collectors.toList());
    }

    @GetMapping("/departments/{id}")
    public Department get(@PathVariable Long id) {
        return addHateoasLinks(departmentRepository.findOne(id));
    }

    public Department addHateoasLinks(Department department) {
        department.add(linkTo(methodOn(DepartmentController.class).get(department.getStid())).withSelfRel());
        department.getEmployees().forEach(
                e -> department.add(linkTo(methodOn(EmployeeController.class).get(e.getStid())).withRel("employees"))
        );
        return department;
    }
}
