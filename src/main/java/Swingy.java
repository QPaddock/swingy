import Player.Enemy;
import Player.Hero;
import game.Board;
import game.Run;
import gui.Swing;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Swingy {
    public static void main(String [] args) {
        int level;
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
                System.out.println("4. Load Player");
                try {
                    cls = scan.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Invalid input exit " + e);
                }
                if (cls == 4) {
                    String line = null;
                    try {
                        FileReader read = new FileReader("Players.txt");
                        BufferedReader buff = new BufferedReader(read);
                        while((line = buff.readLine()) != null) {
                            System.out.println(line);
                        }
                        buff.close();
                    }catch (FileNotFoundException e) {
                        System.out.println("No file.");
                    }catch (IOException e) {
                        System.out.println("error");
                    }
                }
                else if (cls >= 1 && cls <= 3){
                    System.out.println("Please enter your Hero's name:");
                    name = scan.next();
                    Hero player = new Hero(name, cls);
                    level = player.getLevel();
                    int size = (player.getLevel() - 1)*5+10-(player.getLevel()%2);
                    Enemy[] enemy = new Enemy[size];
                    Board board = new Board(player, size);
                    for (int i = 0; i < size; i++) {
                        enemy[i] = new Enemy(player.getLevel(), size);
                        board.placeEnemy(enemy[i]);
                    }
                    Run run = new Run(enemy, player, board);
                    while (player.getAlive() == true) {
                        if (run.getMove(enemy, player, board) == 1 || level < player.getLevel()) {
                            size = (player.getLevel() - 1)*5+10-(player.getLevel()%2);
                            board = new Board(player, size);
                            enemy = new Enemy[size + 2];
                            for (int i = 0; i < size; i++) {
                                enemy[i] = new Enemy(player.getLevel(), size);
                                board.placeEnemy(enemy[i]);
                            }
                            level = player.getLevel();
                        }
                        board.printBoard();
                    }
                    String filename = name + ".txt";
                    try (FileWriter write = new FileWriter(filename); BufferedWriter buff = new BufferedWriter(write)) {
                        buff.write(name);
                        buff.newLine();
                        buff.write(Integer.toString(player.getXP()));
                        buff.newLine();
                        buff.write(Integer.toString(player.getLevel()));
                        buff.newLine();
                        buff.write(Integer.toString(player.getAttack()));
                        buff.newLine();
                        buff.write(Integer.toString(player.getDefense()));
                        buff.newLine();
                        buff.write(Integer.toString(player.getHitPoints()));

                    } catch (IOException e) {
                        System.err.println("IOException");
                    }
                    try (FileWriter write = new FileWriter("Players.txt"); BufferedWriter buff = new BufferedWriter(write)) {
                        buff.write(filename);
                        buff.newLine();
                    } catch (IOException e) {
                        System.err.println("IOException");
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
