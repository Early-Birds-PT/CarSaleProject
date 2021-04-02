package service.impl;

import data.model.entity.Customer;
import repository.CustomerRepository;
import service.CustomerService;
import service.OrderService;
import utils.RepositoryBeanFactory;
import utils.ServiceBeanFactory;
import java.util.List;
import java.util.Random;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository = RepositoryBeanFactory.getCustomerRepository();
    private OrderService orderService = ServiceBeanFactory.getOrderService();

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

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    private int generateUniqueID() {
        int number = 0;
        do{
            number = new Random().nextInt(100000000);
        } while(customerRepository.readCustomer(number) != null);
        return number;
    }
}
