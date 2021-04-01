package service.impl;

import data.model.entity.Customer;
import repository.CustomerRepository;
import repository.repository_impl.CustomerRepositoryImpl;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.createCustomer(customer);
    }

    @Override
    public Customer readCustomer(int customerNumber) {
        return customerRepository.readCustomer(customerNumber);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public boolean deleteCustomer(int customerNumber) {
        return customerRepository.deleteCustomer(customerNumber);
    }

    // TODO : findAllCustomersByEmployee or define Customer list in Employee entity
}
