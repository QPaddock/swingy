package Player;

import java.util.Random;

public class Enemy {
    public Boolean alive;
    public int x;
    public int y;
    protected int Attack;
    protected int Defense;
    protected int hitPoints;

    public Enemy(int level, int size) {
        Random r = new Random();
        setAttack((r.nextInt(60)));
        setDefense((r.nextInt(50)));
        setHitPoints((r.nextInt(100)));
        setX(r.nextInt(size));
        setY(r.nextInt(size));
        setAlive(true);
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public void setDefense(int defense) {
        Defense = defense;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Boolean getAlive() {
        return alive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAttack() {
        return Attack;
    }

    public int getDefense() {
        return Defense;
    }

    public int getHitPoints() {
        return hitPoints;
    }
}
