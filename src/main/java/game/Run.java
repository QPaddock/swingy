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
        System.out.printf("Please enter %s's move (North, South, East, West)/(N, S, E, W): \n", player.getHeroName());
        move = scan.next().toUpperCase();
        if (move.equals("NORTH") || move.equals("N")) {
            player.setY(player.getY() - 1);
        }
        else if (move.equals("SOUTH") || move.equals("S")) {
            player.setY(player.getY() + 1);
        }
        else if (move.equals("EAST") || move.equals("E")) {
            player.setX(player.getX() + 1);
        }
        else if (move.equals("WEST") || move.equals("W")) {
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
                board.moveHero(player, 1);
            }
            if (res == 2) {
                board.moveHero(player, 0);
            }
            else {
                return 0;
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
                        System.out.println("Ran Unsuccessfully\nFighting!");
                        return fightSim(enemy, player, i);
                    }
                }
                else if (move.equals("FIGHT")) {
                    System.out.println("Fighting!");
                    return fightSim(enemy, player, i);
                }
                else {
                    System.out.println("Default, You are running!");
                    return 1;
                }
            }
        }
        return 1;
    }

    private int fightSim(Enemy[] enemy, Hero player, int i) {
        int fightres = Fight(player, enemy[i]);
        if (fightres == 1) {
            System.out.println("Enemy Defeated!");
            Random r = new Random();
            int res = r.nextInt(5);
            if (res == 1){
                System.out.println("Enemy dropped weapon!");
                res = r.nextInt(30);
                player.setWeapon(res);
                System.out.printf("Attack increases by %d\n", res);
            }
            else if (res == 2) {
                System.out.println("Enemy dropped armor!");
                res = r.nextInt(30);
                player.setArmor(res);
                System.out.printf("Defense increases by %d\n", res);
            }
            else if (res == 3) {
                System.out.println("Enemy dropped helmet!");
                res = r.nextInt(30);
                player.setHelm(res);
                System.out.printf("Hit points increases by %d\n", res);
            }
            System.out.println(res);
            return 2;
        }
        else if (fightres == 0) {
            System.out.println("Player Dead!");
            return 0;
        }
        return 1;
    }

    private int Fight(Hero player, Enemy enemy) {
        int res;
        while (true) {
            res = (enemy.getAttack() - player.getDefense());
            if (res < 0)
                res = 0;
            player.setHitPoints(player.getHitPoints() - res);
            System.out.printf("Enemy hits %s delivering %d of damage. %s has %d Health left!\n", player.getHeroName(), res, player.getHeroName(), player.getHitPoints());
            if (!player.getAlive()) {
                return 0;
            }
            res = (player.getAttack() - enemy.getDefense());
            if (res < 0)
                res = 0;
            enemy.setHitPoints(enemy.getHitPoints() - res);
            System.out.printf("%s hits %s delivering %d of damage. %s has %d Health left!\n", player.getHeroName(),"Enemy", res,"Enemy", enemy.getHitPoints());
            if (!enemy.getAlive()){
                return 1;
            }
        }
    }
}
