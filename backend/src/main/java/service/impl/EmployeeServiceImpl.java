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
}
