package service.impl;


import data.model.entity.Office;
import repository.EmployeeRepository;
import repository.repository_impl.EmployeeRepositoryImpl;
import data.model.entity.Employee;
import service.EmployeeService;

import java.util.Random;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setEmployeeNumber(generateUniqueID());
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

    private int generateUniqueID() {
        int number = 0;
        do{
            number = new Random().nextInt(100000000);
        } while(employeeRepository.readEmployee(number) != null);
        return number;
    }
}
