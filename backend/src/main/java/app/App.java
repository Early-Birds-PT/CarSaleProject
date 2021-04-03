package app;

import view.CLI;
import view.UserInterface;

public class App {

    public static void main(String[] args) {

        if (args.length == 0) {
           UserInterface.start();
        }
        else{
            CLI.commandFromCLI(args[0]);
        }


//        List<Customer> allCustomers= ServiceBeanFactory.getCustomerService().getAllCustomers();
//        allCustomers.forEach(customer -> System.out.println(customer));

        /*List<Employee> allEmployees= ServiceBeanFactory.getEmployeeService().getAllEmployees();
        allEmployees.forEach(employee -> System.out.println(employee));

        List<Product> allProducts = ServiceBeanFactory.getProductService().getAllProducts();
        allProducts.forEach(product -> System.out.println(product));*/


        /*Customer customer = ServiceBeanFactory.getCustomerService().readCustomer(181);
        List<Order> orderList = ServiceBeanFactory.getOrderService().findAllOrdersByCustomer(customer);
        orderList.forEach(order -> System.out.println(order));

        List<Payment> paymentList = ServiceBeanFactory.getPaymentService().findAllPaymentsByCustomer(customer);
        paymentList.forEach(payment -> System.out.println(payment));*/

        /*Customer customer = ServiceBeanFactory.getCustomerService().readCustomer(103);
        PaymentId paymentId = new PaymentId("OM314933",customer);
        ServiceBeanFactory.getOrderService().deleteOrder(10100);
        ServiceBeanFactory.getCustomerService().deleteCustomer(128);
        Payment payment = ServiceBeanFactory.getPaymentService().readPayment(paymentId);
        payment.setAmount(new BigDecimal(999999.45));
        System.out.println(ServiceBeanFactory.getPaymentService().updatePayment(payment));
        payment.setPaymentId(new PaymentId("14082001",customer));
        System.out.println(ServiceBeanFactory.getPaymentService().createPayment(payment));*/

        /*EmployeeService employeeService = new EmployeeServiceImpl();

        System.out.println(employeeService.deleteEmployee(1102));*/


//        CustomerService customerService = new CustomerServiceImpl();
//       // Customer customer = customerService.readCustomer(363);
//        System.out.println(customerService.deleteCustomer(103));
/*
        ProductService productService = new ProductServiceImpl();
        ProductLineService productLineService = new ProductLineServiceImpl();

        ProductLine productLine = productLineService.readProductLine("Motorcycles");

        productLine.setTextDescription("Updated");
        //productLine.setProductLine("New Product Line");

        System.out.println(productLineService.updateProductLine(productLine));

        //System.out.println(productLineService.deleteProductLine("Planes"));
        //productService.findAllProductsByProductLine(productLine).forEach(System.out::println);

        //Product product = productService.readProduct("S10_1678");

        //System.out.println(productService.deleteProduct("S10_1678"));
        //OrderDetailService orderDetailService = new OrderDetailServiceImpl();

        //List<OrderDetail> orderDetails = orderDetailService.findAllOrderDetailsByProduct(product);

        //orderDetails.forEach(System.out::println);

        // System.out.println(productService.updateProduct(product));

        //System.out.println(productService.deleteProduct("S10_1678"));


//        OrderService orderService = new OrderServiceImpl();
//        List<Order> orders = orderService.findAllOrdersByCustomer(customer);
//        System.out.println(orders);


       /* PaymentService paymentService = new PaymentServiceImpl();
        Payment payment = paymentService.readPayment("HQ336336");
        System.out.println(payment);

        Customer customer1 = new Customer();
        customer1.setCustomerName("Mert Demirok");
        customer1.setContactFirstName("Mert");
        customer1.setContactLastName("Demirok");
        customer1.setCountry("Belgium");
        customer1.setAddressLine1("Straat");
        customer1.setPhone("0458564589");
        customer1.setCreditLimit(BigDecimal.valueOf(1000));
        customer1.setCity("Leuven");*/

        // customerService.createCustomer(customer1);
        //OfficeService officeService = new OfficeServiceImpl();
        /*Office office1 = officeService.readOffice("8");
        System.out.println(office1);*/

        // office1.setOfficeCode(String.valueOf(generateUniqueID(officeService)));
        /*office1.setCity("Sivas");
        office1 = officeService.createOffice(office1);
        System.out.println(office1);*/

        //officeService.deleteOffice("5");


        // officeService.updateOffice(office1);

    }
}
