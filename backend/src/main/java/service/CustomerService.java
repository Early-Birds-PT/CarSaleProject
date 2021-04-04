package service;

import data.model.entity.Customer;
import data.model.entity.Employee;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer);
    Customer readCustomer(int customerNumber);
    Customer updateCustomer(Customer customer);
    boolean deleteCustomer(int customerNumber);
    List<Customer> getAllCustomers();
    List<Customer> findAllCustomersByEmployee(Employee employee);
}
