package view;

import data.model.embeddable.OrderDetailId;
import data.model.embeddable.PaymentId;
import data.model.entity.*;
import repository.repository_impl.PaymentRepositoryImpl;
import service.ProductService;
import service.impl.ProductServiceImpl;
import utils.ServiceBeanFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class DeleteItem_UI {

    void manageDeleteItemCommand(Scanner scanner) {
        while (true) {
            System.out.println("Commands:");
            System.out.println("1 - delete office");
            System.out.println("2 - delete employee");
            System.out.println("3 - delete customer");
            System.out.println("4 - delete payment");
            System.out.println("5 - delete order");
            System.out.println("6 - delete order detail");
            System.out.println("7 - delete product");
            System.out.println("8 - delete product line");
            System.out.println("X - return to main menu");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("X")) {
                break;
            }

            this.manageCommand(command, scanner);
        }
    }

    private void manageCommand(String command, Scanner scanner) {
        switch (command) {
            case "1":
                System.out.println("Enter office code");
                String input = scanner.nextLine();
                System.out.println(ServiceBeanFactory.getOfficeService().deleteOffice(input));
                break;
            case "2":
                System.out.println("Enter employee number");
                input = scanner.nextLine();
                System.out.println(ServiceBeanFactory.getEmployeeService().deleteEmployee(Integer.valueOf(input)));
                break;
            case "3":
                System.out.println("Enter customer number");
                input = scanner.nextLine();
                System.out.println(ServiceBeanFactory.getCustomerService().deleteCustomer(Integer.valueOf(input)));
                break;
            case "4":
                System.out.println("Enter check number");
                String checkNumber = scanner.nextLine();

                System.out.println("Enter customer number");
                String customerNumber = scanner.nextLine();

                Customer customer = ServiceBeanFactory.getCustomerService().readCustomer(Integer.valueOf(customerNumber));
                Payment payment = ServiceBeanFactory.getPaymentService().readPayment(new PaymentId(checkNumber,customer));
                System.out.println(ServiceBeanFactory.getPaymentService().deletePayment(payment.getPaymentId()));

                break;
            case "5":
                System.out.println("Enter order number");
                input = scanner.nextLine();
                System.out.println(ServiceBeanFactory.getOrderService().deleteOrder(Integer.valueOf(input)));
                break;
            case "6":
                System.out.println("Enter order number");
                String orderNumber = scanner.nextLine();

                System.out.println("Enter product code");
                String productCode = scanner.nextLine();

                Order order = ServiceBeanFactory.getOrderService().readOrder(Integer.valueOf(orderNumber));
                Product product = ServiceBeanFactory.getProductService().readProduct(productCode);

                System.out.println(ServiceBeanFactory.getOrderDetailService().deleteOrderDetail(new OrderDetailId(order, product)));
                break;
            case "7":
                System.out.println("Enter product code");
                input = scanner.nextLine();
                System.out.println(ServiceBeanFactory.getProductService().deleteProduct(input));
                break;
            case "8":
                System.out.println("Enter product line");
                input = scanner.nextLine();
                System.out.println(ServiceBeanFactory.getProductLineService().deleteProductLine(input));
                break;
        }
    }

}
