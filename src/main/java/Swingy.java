import Player.Hero;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Swingy {
    public static void main(String [] args) {
        boolean inputValid = false;
        String name = null;
        int cls = 0;

        Scanner scan = new Scanner(System.in);
        try {
            String game = args[0];
            if (game.equals("Console")) {
                System.out.println("Console...");
                while (inputValid == false) {
                    System.out.println("Please choose your Hero:");
                    System.out.println("1. Foot Soldier     class: 1");
                    System.out.println("2. Archer           class: 2");
                    System.out.println("3. Knight           class: 3");
                    try {
                        cls = scan.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Invalid input exit " + e);
                    }
                    if (cls >= 1 || cls <= 3){
                        System.out.println("Please enter your Hero's name:");
                        name = scan.next();
                        inputValid = true;
                    }
                }
                Hero player = new Hero(name, cls);

            }
            else
                System.out.println("Error: No Arguments");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }
}