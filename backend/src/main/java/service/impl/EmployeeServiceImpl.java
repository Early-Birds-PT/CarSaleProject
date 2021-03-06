package service.impl;

import model.entity.Employee;
import model.entity.Office;
import repository.EmployeeRepository;
import service.EmployeeService;
import utils.RepositoryBeanFactory;
import java.util.List;
import java.util.Random;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository = RepositoryBeanFactory.getEmployeeRepository();

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
    public List<Employee> findAllEmployeesByRefersTo(Employee employee) {
        return employeeRepository.findAllEmployeesByRefersTo(employee);
    }


    @Override
    public List<Employee> findAllEmployeesByOffice(Office office) { return employeeRepository.findAllEmployeesByOffice(office);
    }

    @Override
    public Employee transferEmployee(Employee employee, Office office) {
        employee.setOffice(office);
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    private int generateUniqueID() {
        int number = 0;
        do {
            number = new Random().nextInt(100000000);
        } while (employeeRepository.readEmployee(number) != null);
        return number;
    }
}
