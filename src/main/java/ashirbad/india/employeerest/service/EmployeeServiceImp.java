package ashirbad.india.employeerest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ashirbad.india.employeerest.entity.Employee;
import ashirbad.india.employeerest.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    private EmployeeRepository empRepo;

    @Override
    public List<Employee> findAll() {
        // List<Employee> employees = empRepo.findAll();
        return empRepo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> res = empRepo.findById(id);
        if(res.isPresent()){
            return res.get();
        }
        return null;
    }

    @Override
    public Employee save(Employee emp) {
        Employee saved = empRepo.save(emp);
        return saved;
    }

    @Override
    public void delete(int id) {
        empRepo.deleteById(id);
    }

    @Override
    public Employee update(int id, Employee emp) {
        emp.setId(id);
        Employee updated = empRepo.save(emp);
        return updated;
    }
    
}
