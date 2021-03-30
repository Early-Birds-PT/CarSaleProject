package service;

import data.model.entity.Customer;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer readCustomer(int customerNumber);
}
