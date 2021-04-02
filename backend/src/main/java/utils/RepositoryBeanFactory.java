package utils;

import repository.*;
import repository.repository_impl.*;

public class RepositoryBeanFactory {

    private static CustomerRepository customerRepository;
    private static EmployeeRepository employeeRepository;
    private static OfficeRepository officeRepository;
    private static OrderRepository orderRepository;
    private static OrderDetailRepository orderDetailRepository;
    private static PaymentRepository paymentRepository;
    private static ProductLineRepository productLineRepository;
    private static ProductRepository productRepository;

    public static CustomerRepository getCustomerRepository() {
        if(customerRepository == null){
            customerRepository = new CustomerRepositoryImpl();
        }
        return customerRepository;
    }

    public static EmployeeRepository getEmployeeRepository() {
        if(employeeRepository == null){
            employeeRepository = new EmployeeRepositoryImpl();
        }
        return employeeRepository;
    }

    public static OfficeRepository getOfficeRepository() {
        if(officeRepository == null){
            officeRepository = new OfficeRepositoryImpl();
        }
        return officeRepository;
    }

    public static OrderDetailRepository getOrderDetailRepository() {
        if(orderDetailRepository == null){
            orderDetailRepository = new OrderDetailRepositoryImpl();
        }
        return orderDetailRepository;
    }

    public static OrderRepository getOrderRepository() {
        if(orderRepository == null){
            orderRepository = new OrderRepositoryImpl();
        }
        return orderRepository;
    }

    public static PaymentRepository getPaymentRepository() {

        if(paymentRepository == null){
            paymentRepository = new PaymentRepositoryImpl();
        }
        return paymentRepository;
    }

    public static ProductLineRepository getProductLineRepository() {

        if (productLineRepository == null){
            productLineRepository = new ProductLineRepositoryImpl();
        }
        return productLineRepository;
    }
    public static ProductRepository getProductRepository() {
        if (productRepository == null ){
            productRepository = new ProductRepositoryImpl();
        }
        return productRepository;
    }
}
