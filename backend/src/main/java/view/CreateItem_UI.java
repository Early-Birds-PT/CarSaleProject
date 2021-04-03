package view;

import data.model.entity.*;
import utils.ServiceBeanFactory;
import java.util.Scanner;

public class CreateItem_UI {
    void manageCreateItemCommand(Scanner scanner) {
        while(true){
            System.out.println("Commands:");
            System.out.println("1 - create office");
            System.out.println("2 - create employee");
            System.out.println("3 - create customer");
            System.out.println("4 - create payment");
            System.out.println("5 - create order");
            System.out.println("6 - create order detail");
            System.out.println("7 - create product");
            System.out.println("8 - create product line");
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
                Office office = createOffice(scanner);
                ServiceBeanFactory.getOfficeService().createOffice(office);
                break;
            case "2":
                Employee employee = createEmployee(scanner);
                ServiceBeanFactory.getEmployeeService().createEmployee(employee);
                break;
            case "3":

                break;
            case "4":

                break;
            case "5":

                break;
            case "6":

                break;
            case "7":

                break;
            case "8":

                break;
        }
    }

    private Employee createEmployee(Scanner scanner) {
        System.out.println("Enter last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter extension");
        String extension = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();
        System.out.println("Enter job title");
        String jobTitle = scanner.nextLine();

        System.out.println("Enter office code");
        String officeCode = scanner.nextLine();
        Office office = ServiceBeanFactory.getOfficeService().readOffice(officeCode);

        return new Employee(null, lastName, firstName, extension, email, jobTitle, null, office);
    }

    private Office createOffice(Scanner scanner) {
        System.out.println("Enter city");
        String city = scanner.nextLine();
        System.out.println("Enter phone");
        String phone = scanner.nextLine();
        System.out.println("Enter address line 1");
        String addressLine1 = scanner.nextLine();
        System.out.println("Enter address line 2");
        String addressLine2 = scanner.nextLine();
        System.out.println("Enter state");
        String state = scanner.nextLine();
        System.out.println("Enter postal code");
        String postalCode = scanner.nextLine();
        System.out.println("Enter country");
        String country = scanner.nextLine();
        System.out.println("Enter territory");
        String territory = scanner.nextLine();

        Office office = new Office(null, city, phone, addressLine1, addressLine2, state, postalCode, country, territory);
        return office;
    }
}