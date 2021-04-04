package service;


import data.model.entity.Employee;
import data.model.entity.Office;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);
    Employee readEmployee(int employeeNumber);
    Employee updateEmployee(Employee employee);
    boolean deleteEmployee(int employeeNumber);
    List<Employee> findAllEmployeesByRefersTo(Employee employee);
    Employee transferEmployee(Employee employee, Office office);
    List<Employee> getAllEmployees();
}
