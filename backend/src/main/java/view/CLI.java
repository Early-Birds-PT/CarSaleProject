package view;

import utils.ServiceBeanFactory;

public class CLI {

    public static void commandFromCLI(String command) {
        if(command.equals("1")){
            ReadAll_UI.showAllCustomersAsATable();
        } else if(command.equals("2")){
            ReadAll_UI.showAllEmployeesAsATable();
        } else{
            ReadAll_UI.showAllProductsAsATable();
        }
    }
}
