package service.impl;


import data.model.entity.Office;
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
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int employeeNumber) {
        return employeeRepository.deleteEmployee(employeeNumber);
    }

    @Override
    public Employee transferEmployee(Employee employee, Office office) {
        //employee.setEmployee(null);
        employee.setOffice(office);
        return employeeRepository.updateEmployee(employee);
    }
}
