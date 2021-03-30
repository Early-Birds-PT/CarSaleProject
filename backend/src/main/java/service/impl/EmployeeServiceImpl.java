package service.impl;


import repository.EmployeeRepository;
import repository.repository_impl.EmployeeRepositoryImpl;
import data.model.entity.Employee;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }

    @Override
    public Employee readEmployee(int employeeNumber) {
        return employeeRepository.readEmployee(employeeNumber);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int employeeNumber) {
        employeeRepository.deleteEmployee(employeeNumber);
    }
}
