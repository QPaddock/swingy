package game;

import Player.Enemy;
import Player.Hero;

import java.util.Random;
import java.util.Scanner;

public class Run {
    public Run(Enemy[] enemy, Hero player, Board board){
    }

    public int getMove(Enemy[] enemy, Hero player, Board board){
        Scanner scan = new Scanner(System.in);
        String move;
        System.out.printf("Please enter %s's move: ", player.getHeroName());
        move = scan.next().toUpperCase();
        if (move.equals("NORTH")) {
            player.setY(player.getY() - 1);
        }
        else if (move.equals("SOUTH")) {
            player.setY(player.getY() + 1);
        }
        else if (move.equals("EAST")) {
            player.setX(player.getX() + 1);
        }
        else if (move.equals("WEST")) {
            player.setX(player.getX() - 1);
        }
        else {
            System.out.println("Invalid Move");
            return 0;
        }
        int res = board.moveHero(player, 0);
        if (res == 1) {
            return 1;
        }
        if (res == 2) {
            res = FightOrFlight(enemy, player);
            if (res == 1) {
                System.out.println("here too");
                board.moveHero(player, 1);
            }
        }
        return 0;
    }

    private int FightOrFlight(Enemy[] enemy, Hero player) {
        int size = (player.getLevel() - 1)*5+10-(player.getLevel()%2);
        for (int i = 0; i < size; i++) {
            if (enemy[i].getX() == player.getX() && enemy[i].getY() == player.getY()) {
                Scanner scan = new Scanner(System.in);
                String move;
                System.out.printf("Would %s like to Fight or Run: ", player.getHeroName());
                move = scan.next().toUpperCase();
                if (move.equals("RUN")){

                    Random r = new Random();
                    if (r.nextBoolean()) {
                        System.out.println("Ran Successfully");
                        return 1;
                    }
                    else {
                        System.out.println("Ran Unsuccessfully");
                        fightSim(enemy, player, i);
                    }
                }
                else if (move.equals("FIGHT")) {
                    System.out.println("FIGHTING");
                    fightSim(enemy, player, i);
                }
                else {
                    System.out.println("Default, You are running!");
                    return 1;
                }
            }
        }
        return 1;
    }

    private void fightSim(Enemy[] enemy, Hero player, int i) {
        int fightres = Fight(player, enemy[i]);
        if (fightres == 1) {
            System.out.println("Enemy Defeated!");
            enemy[i].setAlive(false);
        }
        else if (fightres == 0) {
            System.out.println("Player Dead!");
            player.setAlive(false);
        }
    }

    private int Fight(Hero player, Enemy enemy) {
        while (true) {
            player.setHitPoints(player.getHitPoints() - (enemy.getAttack() - player.getDefense()));
            if (!player.getAlive()) {
                return 0;
            }
            enemy.setHitPoints(enemy.getHitPoints() - (player.getAttack() - enemy.getDefense()));
            if (!enemy.getAlive()){
                return 1;
            }
        }
    }
}
