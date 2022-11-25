package ashirbad.india.employeerest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ashirbad.india.employeerest.controller.helper.ResponseHandler;
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

    @GetMapping("")
    public ResponseEntity<Object> getAll(){
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, eService.findAll());
    }

    @GetMapping("/{eId}")
    public ResponseEntity<Object> getById(@PathVariable int eId){
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, eService.findById(eId));
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody Employee emp) {
        Employee saved = eService.save(emp);
        return ResponseHandler.generateResponse("Employee created successfully", HttpStatus.OK, saved);
    }
    
    @PutMapping("/{eId}")
    public ResponseEntity<Object> update(@PathVariable int eId, @RequestBody Employee emp){
        Employee updated = eService.update(eId, emp);
        return ResponseHandler.generateResponse("Employee updated successfully", HttpStatus.OK, updated);
    }

    @DeleteMapping("/{eId}")
    public ResponseEntity<Object> delete(@PathVariable int eId){
        eService.delete(eId);
        return ResponseHandler.generateResponse("Employee removed successfully", HttpStatus.OK, null);
    }
}
