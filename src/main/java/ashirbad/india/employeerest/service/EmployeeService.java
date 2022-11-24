package ashirbad.india.employeerest.service;

import java.util.List;

import ashirbad.india.employeerest.entity.Employee;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int id);
    public Employee save(Employee emp);
    public Employee update(int id, Employee emp);
    public void delete(int id);
}
