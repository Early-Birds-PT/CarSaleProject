package utils;

import service.*;
import service.impl.*;

public class ServiceBeanFactory {

    private static CustomerService customerService;
    private static EmployeeService employeeService;
    private static OfficeService officeService;
    private static OrderService orderService;
    private static OrderDetailService orderDetailService;
    private static PaymentService paymentService;
    private static ProductLineService productLineService;
    private static ProductService productService;

    public static CustomerService getCustomerService() {
        if(customerService == null){
            customerService = new CustomerServiceImpl();
        }
        return customerService;
    }

    public static EmployeeService getEmployeeService() {
        if(employeeService == null){
            employeeService = new EmployeeServiceImpl();
        }
        return employeeService;
    }

    public static OfficeService getOfficeService() {
        if(officeService == null){
            officeService = new OfficeServiceImpl();
        }
        return officeService;
    }

    public static OrderDetailService getOrderDetailService() {
        if(orderDetailService == null){
            orderDetailService = new OrderDetailServiceImpl();
        }
        return orderDetailService;
    }

    public static OrderService getOrderService() {
        if(orderService == null){
            orderService = new OrderServiceImpl();
        }
        return orderService;
    }

    public static PaymentService getPaymentService() {

        if(paymentService == null){
            paymentService = new PaymentServiceImpl();
        }
        return paymentService;
    }

    public static ProductLineService getProductLineService() {

        if (productLineService == null){
            productLineService = new ProductLineServiceImpl();
        }
        return productLineService;
    }
    public static ProductService getProductService() {
        if (productService == null ){
            productService = new ProductServiceImpl();
        }
        return productService;
    }
}
