package repository;


import data.model.entity.Employee;

public interface EmployeeRepository {

    Employee createEmployee(Employee employee);
    Employee readEmployee(int employeeNumber);
    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee, int employeeNumber);

}
