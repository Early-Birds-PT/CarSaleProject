package service;


import data.model.entity.Employee;

public interface EmployeeService {

    Employee createEmployee(Employee employee);
    Employee readEmployee(int employeeNumber);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeNumber);
}
