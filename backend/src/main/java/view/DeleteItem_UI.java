package view;

import model.embeddable.OrderDetailId;
import model.embeddable.PaymentId;
import model.entity.Customer;
import model.entity.Order;
import model.entity.Product;
import utils.ServiceBeanFactory;

import java.util.Scanner;

public class DeleteItem_UI {

    public void manageDeleteItemCommand(Scanner scanner) {
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
                Boolean isDeleted = ServiceBeanFactory.getOfficeService().deleteOffice(input);
                System.out.println("STATUS Deleted: " + isDeleted);
                break;
            case "2":
                System.out.println("Enter employee number");
                input = scanner.nextLine();
                Boolean isDeleted2 = ServiceBeanFactory.getEmployeeService().deleteEmployee(Integer.valueOf(input));
                System.out.println("STATUS Deleted: " + isDeleted2);
                break;
            case "3":
                System.out.println("Enter customer number");
                input = scanner.nextLine();
                Boolean isDeleted3 = ServiceBeanFactory.getCustomerService().deleteCustomer(Integer.valueOf(input));
                System.out.println("STATUS Deleted: " + isDeleted3);
                break;
            case "4":
                System.out.println("Enter check number");
                String checkNumber = scanner.nextLine();

                System.out.println("Enter customer number");
                String customerNumber = scanner.nextLine();

                Customer customer = ServiceBeanFactory.getCustomerService().readCustomer(Integer.valueOf(customerNumber));
                Boolean isDeleted4 = ServiceBeanFactory.getPaymentService().deletePayment(new PaymentId(checkNumber, customer));
                System.out.println(isDeleted4);
                break;
            case "5":
                System.out.println("Enter order number");
                input = scanner.nextLine();
                Boolean isDeleted5 = ServiceBeanFactory.getOrderService().deleteOrder(Integer.valueOf(input));
                System.out.println("STATUS Deleted: " + isDeleted5);
                break;
            case "6":
                System.out.println("Enter order number");
                String orderNumber = scanner.nextLine();

                System.out.println("Enter product code");
                String productCode = scanner.nextLine();

                Order order = ServiceBeanFactory.getOrderService().readOrder(Integer.valueOf(orderNumber));
                Product product = ServiceBeanFactory.getProductService().readProduct(productCode);

                Boolean isDeleted6 = ServiceBeanFactory.getOrderDetailService().deleteOrderDetail(new OrderDetailId(order, product));
                System.out.println("STATUS Deleted: " + isDeleted6);
                break;
            case "7":
                System.out.println("Enter product code");
                input = scanner.nextLine();
                Boolean isDeleted7 = ServiceBeanFactory.getProductService().deleteProduct(input);
                System.out.println("STATUS Deleted: " + isDeleted7);
                break;
            case "8":
                System.out.println("Enter product line");
                input = scanner.nextLine();
                Boolean isDeleted8 = ServiceBeanFactory.getProductLineService().deleteProductLine(input);
                System.out.println("STATUS Deleted: " + isDeleted8);
                break;
        }
    }
}
