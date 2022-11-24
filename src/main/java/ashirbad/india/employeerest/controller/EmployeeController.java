package ashirbad.india.employeerest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ashirbad.india.employeerest.entity.Employee;
import ashirbad.india.employeerest.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService eService;

    @GetMapping("/")
    public List<Employee> getAll(){
        return eService.findAll();
    }

    @GetMapping("/{eId}")
    public Employee getById(@PathVariable int eId){
        return eService.findById(eId);
    }

    @PostMapping("/")
    public Employee save(@RequestBody Employee emp) {
        Employee saved = eService.save(emp);
        return saved;
    }
    
    @PutMapping("/{eId}")
    public Employee update(@PathVariable int eId, @RequestBody Employee emp){
        Employee updated = eService.update(eId, emp);
        return updated;
    }

    @DeleteMapping("/{eId}")
    public String delete(@PathVariable int eId){
        eService.delete(eId);
        return "Successfully Removed";
    }
}
