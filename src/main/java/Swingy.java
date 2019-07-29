import Player.Enemy;
import Player.Hero;
import game.Board;
import game.Run;
import gui.Swing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Swingy {
    public static void main(String [] args) {
        String name = null;
        int cls = 0;

        Scanner scan = new Scanner(System.in);
        try {
            String game = args[0];
            if (game.equals("Console")) {
                System.out.println("Console...");
                System.out.println("Please choose your Hero:");
                System.out.println("1. Foot Soldier     class: 1");
                System.out.println("2. Archer           class: 2");
                System.out.println("3. Knight           class: 3");
                try {
                    cls = scan.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Invalid input exit " + e);
                }
                if (cls >= 1 && cls <= 3){
                    System.out.println("Please enter your Hero's name:");
                    name = scan.next();
                    Hero player = new Hero(name, cls);
                    int size = (player.getLevel() - 1)*5+10-(player.getLevel()%2);
                    Enemy[] enemy = new Enemy[size];
                    Board board = new Board(player, size);
                    for (int i = 0; i < size; i++) {
                        enemy[i] = new Enemy(player.getLevel(), size);
                        board.placeEnemy(enemy[i]);
                    }
                    Run run = new Run(enemy, player, board);
                    while (player.getAlive() == true) {
                        if (run.getMove(enemy, player, board) == 1) {
                            size = (player.getLevel() - 1)*5+10-(player.getLevel()%2);
                            board = new Board(player, size);
                            enemy = new Enemy[size + 2];
                            for (int i = 0; i < size; i++) {
                                enemy[i] = new Enemy(player.getLevel(), size);
                                board.placeEnemy(enemy[i]);
                            }
                        }
                        board.printBoard();
                    }

                }
                else {
                    System.out.println("Invalid input: How can you do this?");
                }

            }
            else if (game.equals("GUI")) {
                Swing swing = new Swing();
                swing.showMenu();
            }
            else
                System.out.println("Error: No Arguments");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out Of Bounds Error: " + e.getLocalizedMessage());
        }
    }
}
