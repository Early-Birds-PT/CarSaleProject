package service.impl;

import data.model.entity.Customer;
import data.model.entity.Order;
import repository.CustomerRepository;
import repository.repository_impl.CustomerRepositoryImpl;
import service.CustomerService;
import service.OrderService;

import java.util.List;
import java.util.Random;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository = new CustomerRepositoryImpl();
    private OrderService orderService = new OrderServiceImpl();


    @Override
    public Customer createCustomer(Customer customer) {
        customer.setCustomerNumber(generateUniqueID());
        return customerRepository.createCustomer(customer);
    }

    @Override
    public Customer readCustomer(int customerNumber) {
        return customerRepository.readCustomer(customerNumber);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int customerNumber) {
        return customerRepository.deleteCustomer(customerNumber);
    }

    private int generateUniqueID() {
        int number = 0;
        do{
            number = new Random().nextInt(100000000);
        } while(customerRepository.readCustomer(number) != null);
        return number;
    }

    // TODO : findAllCustomersByEmployee or define Customer list in Employee entity
}
