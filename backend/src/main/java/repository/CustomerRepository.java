package repository;

import model.entity.Customer;
import model.entity.Employee;

import java.util.List;

public interface CustomerRepository {

    Customer createCustomer(Customer customer);
    Customer readCustomer(int customerNumber);
    Customer updateCustomer(Customer customer);
    boolean deleteCustomer(int customerNumber);
    List<Customer> getAllCustomers();
    List<Customer> findAllCustomersByEmployee(Employee employee);
}
