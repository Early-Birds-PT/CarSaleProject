package view;

import data.model.embeddable.OrderDetailId;
import data.model.embeddable.PaymentId;
import data.model.entity.*;
import utils.ServiceBeanFactory;

import java.util.Scanner;

public class ReadItem_UI {
    void handlePrintItemCommands(Scanner scanner) {
        while(true){
            System.out.println("Commands:");
            System.out.println("1 - read office");
            System.out.println("2 - read employee");
            System.out.println("3 - read customer");
            System.out.println("4 - read payment");
            System.out.println("5 - read order");
            System.out.println("6 - read order detail");
            System.out.println("7 - read product");
            System.out.println("8 - read product line");
            System.out.println("X - return to main menu");
            String command = scanner.nextLine();

            if(command.equalsIgnoreCase("X")){
                break;
            }

            this.manageCommand(command, scanner);
        }
    }

    private void manageCommand(String command, Scanner scanner) {
        switch(command){
            case "1":
                System.out.println("Enter office code");
                String input = scanner.nextLine();
                Office office = ServiceBeanFactory.getOfficeService().readOffice(input);
                System.out.println(office);
                break;
            case "2":
                System.out.println("Enter employee number");
                input = scanner.nextLine();
                Employee employee = ServiceBeanFactory.getEmployeeService().readEmployee(Integer.valueOf(input));
                System.out.println(employee);
                break;
            case "3":
                System.out.println("Enter customer number");
                input = scanner.nextLine();
                Customer customer = ServiceBeanFactory.getCustomerService().readCustomer(Integer.valueOf(input));
                System.out.println(customer);
                break;
            case "4":
                System.out.println("Enter check number");
                String checkNumber = scanner.nextLine();

                System.out.println("Enter customer number");
                String customerNumber = scanner.nextLine();

                customer = ServiceBeanFactory.getCustomerService().readCustomer(Integer.valueOf(customerNumber));
                Payment payment = ServiceBeanFactory.getPaymentService().readPayment(new PaymentId(checkNumber, customer));
                System.out.println(payment);
                break;
            case "5":
                System.out.println("Enter order number");
                input = scanner.nextLine();
                Order order = ServiceBeanFactory.getOrderService().readOrder(Integer.valueOf(input));
                System.out.println(order);
                break;
            case "6":
                System.out.println("Enter order number");
                String orderNumber = scanner.nextLine();

                System.out.println("Enter product code");
                String productCode = scanner.nextLine();

                order = ServiceBeanFactory.getOrderService().readOrder(Integer.valueOf(orderNumber));
                Product product = ServiceBeanFactory.getProductService().readProduct(productCode);

                OrderDetail orderDetail = ServiceBeanFactory.getOrderDetailService().readOrderDetail(new OrderDetailId(order, product));
                System.out.println(orderDetail);
                break;
            case "7":
                System.out.println("Enter product code");
                input = scanner.nextLine();
                product = ServiceBeanFactory.getProductService().readProduct(input);
                System.out.println(product);
                break;
            case "8":
                System.out.println("Enter product line");
                input = scanner.nextLine();
                ProductLine productLine = ServiceBeanFactory.getProductLineService().readProductLine(input);
                System.out.println(productLine);
                break;
        }
    }
}
