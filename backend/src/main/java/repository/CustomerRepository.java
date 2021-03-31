package repository;

import data.model.entity.Customer;

public interface CustomerRepository {
    Customer createCustomer(Customer customer);
    Customer readCustomer(int customerNumber);
    Customer updateCustomer(Customer customer);
    boolean deleteCustomer(int customerNumber);
}
