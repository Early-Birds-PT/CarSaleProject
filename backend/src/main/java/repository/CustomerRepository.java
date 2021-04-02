package repository;

import data.model.entity.Customer;
import java.util.List;

public interface CustomerRepository {

    Customer createCustomer(Customer customer);
    Customer readCustomer(int customerNumber);
    Customer updateCustomer(Customer customer);
    boolean deleteCustomer(int customerNumber);
    List<Customer> getAllCustomers();
}
