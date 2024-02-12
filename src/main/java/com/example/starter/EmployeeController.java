package com.example.starter;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository){
        this.repository = repository;
    }

    @GetMapping("/employees")
    List<Employee> all(){
         return repository.findAll();
    }

    @PostMapping("/employees")
   Employee newEmployee(@RequestBody Employee newEmployee){
        return repository.save(newEmployee);
    }

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    Employee EditEmployee(@RequestBody Employee newEmployeeDetails ,@PathVariable Long id){
        return repository.findById(id)
                .map(employee -> {
                    employee.setId(newEmployeeDetails.getId());
                    employee.setName(newEmployeeDetails.getName());
                    employee.setRole(newEmployeeDetails.getRole());
                    return repository.save(employee);
                })
                .orElseGet(()->{
                    newEmployeeDetails.setId(id);
                    return repository.save(newEmployeeDetails);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id){
        repository.deleteById(id);
    }
}
