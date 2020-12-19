package com.sda.company.controller;

import com.github.javafaker.Faker;
import com.sda.company.models.Company;
import com.sda.company.models.Employee;
import com.sda.company.models.Employee;
import com.sda.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// pentru fiecare platforma se realizeaza un Controller custom
@RestController
@RequestMapping("/api/v1/employee")
@ControllerAdvice
// CompanyController realizeaza legatura dintre front-end si back-end
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ResponseEntity - transpune raspunsul in JSON
    // @RequestBody - primeste un JSON si il transforma automat de catre Spring in obiectul nostru, in cazul de fata Company
    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.create(employee));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                                 @RequestParam(defaultValue = "id") String sortBy) {
        return ResponseEntity.ok(employeeService.getAll(pageNo, pageSize, sortBy));
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam Integer id) {
        employeeService.deleteById(id);
    }

    @GetMapping("/findById")
    //  RequestParam - ii spune programului ca va avea nevoie de un parametru de tip Integer id
    public Employee findById(@RequestParam Integer id) {
        return employeeService.findById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.update(employee));
    }

    //aceasta metoda populeaza baza de date cu valorile introduse de noi, in cazul de fata employee random
    @GetMapping("/populate")
    public void populate() {
        Faker faker = new Faker();
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            Employee employee = new Employee();
            employee.setFirstName(faker.name().firstName());
            employee.setLastName(faker.name().lastName());
            employee.setAddress(faker.address().fullAddress());
            employee.setPhoneNumber(faker.phoneNumber().phoneNumber());
            employee.setPersonalNumericCode(faker.number().randomNumber(13, true));
            employee.setEmail(faker.bothify("?????##@yahoo.com"));

            employeeList.add(employee);
        }
        employeeService.createALl(employeeList);
    }
}
