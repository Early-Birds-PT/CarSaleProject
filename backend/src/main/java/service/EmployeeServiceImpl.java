package service;


import data.repository.EmployeeRepository;
import data.repository.repository_impl.EmployeeRepositoryImpl;
import model.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }
}
