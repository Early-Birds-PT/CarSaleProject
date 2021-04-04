package view;

import utils.ServiceBeanFactory;

public class CLI {

    public static void commandFromCLI(String command) {
        if(command.equals("1")){
            ServiceBeanFactory.getCustomerService().getAllCustomers();
        } else if(command.equals("2")){
            ServiceBeanFactory.getProductService().getAllProducts();
        } else{
            ServiceBeanFactory.getEmployeeService().getAllEmployees();
        }
    }
}
