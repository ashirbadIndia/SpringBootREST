package ashirbad.india.employeerest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ashirbad.india.employeerest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
}
