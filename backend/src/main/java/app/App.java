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
    }
}
