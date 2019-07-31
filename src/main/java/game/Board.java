package game;

import Player.Enemy;
import Player.Hero;

public class Board {
    private int hero = 1;
    private int en = 2;

    private int heroX;
    private int heroY;
    private int heroXF;
    private int heroYF;

    int x;
    int y;
    public int[][] board;

    public Board(Hero player, int size) {
        setX(size);
        setY(size);
        player.setX(size/2);
        player.setY(size/2);
        board = new int[x][y];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (j == player.getX() && i == player.getY()) {
                    board[j][i] = hero;
                    heroX = j;
                    heroY = i;
                }
                else
                    board[j][i] = 0;
            }
        }
    }

    public void placeEnemy(Enemy enemy) {
        if (board[enemy.getX()][enemy.getY()] == hero) {
            enemy.setX(enemy.getX()+1);
            placeEnemy(enemy);
        }
        else
            board[enemy.getX()][enemy.getY()] = en;
    }

    public int moveHero(Hero player, int com) {
        if (com == 0) {
            if (player.getX() > this.x - 1 || player.getY() > this.y - 1 || player.getX() < 0 || player.getY() < 0) {
                return 1;
            }
            if (checkEnemy(player) == 1) {
                heroXF = heroX;
                heroYF = heroY;
                board[heroX][heroY] = 0;
                board[player.getX()][player.getY()] = hero;
                heroX = player.getX();
                heroY = player.getY();
                return 2;
            }
            board[heroX][heroY] = 0;
            board[player.getX()][player.getY()] = hero;
            heroX = player.getX();
            heroY = player.getY();
            return 0;
        }
        else if (com == 1) {
            player.setX(heroXF);
            player.setY(heroYF);
            board[heroX][heroY] = 2;
            heroX = player.getX();
            heroY = player.getY();
            return moveHero(player, 0);
        }
        return 0;
    }

    private int checkEnemy(Hero player) {
        if (board[player.getX()][player.getY()] == 2)
            return 1;
        return 0;
    }

    public void printBoard() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.printf("%d", board[j][i]);
            }
            System.out.print('\n');
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
