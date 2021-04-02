package view;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start(){
        while(true){
            System.out.println("Commands:");
            System.out.println("1 - read all");
            System.out.println("2 - read item");
            System.out.println("3 - update item");
            System.out.println("4 - delete item");
            System.out.println("X - stop");
            String command = scanner.nextLine();

            if(command.equalsIgnoreCase("X")){
                break;
            }

            this.manageCommand(command);
        }
    }

    private void manageCommand(String command){
        switch(command){
            case "1":
                new UserInterfaceReadAll().handlePrintAllCommands(scanner);
                break;
            case "2":

                break;
            case "3":

                break;
            case "4":

                break;

        }
    }




}
