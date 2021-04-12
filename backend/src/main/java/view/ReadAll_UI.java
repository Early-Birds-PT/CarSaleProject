package view;

import model.entity.Customer;
import model.entity.Employee;
import model.entity.Product;
import utils.ServiceBeanFactory;

import java.util.List;
import java.util.Scanner;

public class ReadAll_UI {
    public static void managePrintAllCommand(Scanner scanner) {
        while(true){
            System.out.println("Commands:");
            System.out.println("1 - print all customers");
            System.out.println("2 - print all employees");
            System.out.println("3 - print all products");
            System.out.println("X - return to main menu");
            String command = scanner.nextLine();

            if(command.equalsIgnoreCase("X")){
                break;
            }

            manageCommand(command);
        }
    }

    public static void manageCommand(String command) {
        switch(command){
            case "1":
                showAllCustomersAsATable();
                break;
            case "2":
                showAllEmployeesAsATable();
                break;
            case "3":
                showAllProductsAsATable();
                break;
        }
    }

    public static void showAllProductsAsATable() {
        List<Product> products = ServiceBeanFactory.getProductService().getAllProducts();
        System.out.println(Header.PRODUCT_LINE);
        System.out.println(Header.PRODUCT);
        System.out.println(Header.PRODUCT_LINE);
        products.forEach(product -> System.out.println(product));
        System.out.println(Header.PRODUCT_LINE);
    }

    public static void showAllEmployeesAsATable() {
        List<Employee> employees = ServiceBeanFactory.getEmployeeService().getAllEmployees();
        System.out.println(Header.EMPLOYEE_LINE);
        System.out.println(Header.EMPLOYEE);
        System.out.println(Header.EMPLOYEE_LINE);
        employees.forEach(employee -> System.out.println(employee));
        System.out.println(Header.EMPLOYEE_LINE);
    }

    public static void showAllCustomersAsATable() {
        List<Customer> customers = ServiceBeanFactory.getCustomerService().getAllCustomers();
        System.out.println(Header.CUSTOMER_LINE);
        System.out.println(Header.CUSTOMER);
        System.out.println(Header.CUSTOMER_LINE);
        customers.forEach(customer -> System.out.println(customer));
        System.out.println(Header.CUSTOMER_LINE);
    }
}
