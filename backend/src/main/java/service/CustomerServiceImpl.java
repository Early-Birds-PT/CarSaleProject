package service;

import data.model.entity.Customer;
import repository.CustomerRepository;
import repository.repository_impl.CustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.createCustomer(customer);
    }

    @Override
    public Customer readCustomer(int customerNumber) {
        return customerRepository.readCustomer(customerNumber);
    }
}
