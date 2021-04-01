package repository;


import data.model.entity.Employee;

public interface EmployeeRepository {

    Employee createEmployee(Employee employee);
    Employee readEmployee(int employeeNumber);
    Employee updateEmployee(Employee employee);
    boolean deleteEmployee(int employeeNumber);
}
