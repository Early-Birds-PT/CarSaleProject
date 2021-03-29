package service;


import repository.EmployeeRepository;
import repository.repository_impl.EmployeeRepositoryImpl;
import data.model.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }
}
