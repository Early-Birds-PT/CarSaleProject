package service;


import data.model.entity.Employee;
import data.model.entity.Office;

public interface EmployeeService {

    Employee createEmployee(Employee employee);
    Employee readEmployee(int employeeNumber);
    Employee updateEmployee(Employee employee);
    boolean deleteEmployee(int employeeNumber);
    Employee transferEmployee(Employee employee, Office office);

}
