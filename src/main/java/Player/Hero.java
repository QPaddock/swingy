package Player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Hero {
    private String heroName;
    public Boolean alive;
    private int heroClass;
    private int weapon;
    private int armor;
    private int helm;
    private int XP;
    private int level;
    public int x;
    public int y;
    protected int Attack;
    protected int Defense;
    protected int hitPoints;

    public Hero(String name, int cls) {
        Random r = new Random();
        setHeroName(name);
        setAlive(true);
        setHeroClass(cls);
        setXP(0);
        setLevel(1);
        if (cls == 1) {
            setHitPoints(100);
            setDefense(10);
            setAttack(20);
            System.out.println("Foot Soldier " + name + " created");
        }
        else if (cls == 2) {
            setHitPoints(96);
            setDefense(20);
            setAttack(60);
            System.out.println("Archer " + name + " created");
        }
        else {
            setHitPoints(110);
            setDefense(50);
            setAttack(40);
            System.out.println("Knight " + name + " created");
        }
        System.out.printf("Hit Points = %d\nAttack = %d\nDefense = %d\n", getHitPoints(), getAttack(), getDefense());
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public void setHeroClass(int heroClass) {
        this.heroClass = heroClass;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
        setAttack(weapon + getAttack());
    }

    public void setArmor(int armor) {
        this.armor = armor;
        setDefense(armor + getDefense());
    }

    public void setHelm(int helm) {
        this.helm = helm;
        setHitPoints(helm + getHitPoints());
    }

    public void setXP(int xp) {
        int next = (this.level) * 1000 + (((this.level) - 1)*((this.level) - 1))*450;
        System.out.printf("XP: %d/%d\n", xp, next);
        this.XP = xp;
        if (this.XP >= next) {
            System.out.println("Leveled up! Current level: " + (getLevel()+1) + " Hit Points, Defense and Attack");
            setHitPoints(getHitPoints() + (level * 10));
            setAttack(getAttack() + 10);
            setDefense(getDefense() + 10);
            System.out.printf("Hit Points = %d\nAttack = %d\nDefense = %d\n", getHitPoints(), getAttack(), getDefense());
            setLevel(getLevel()+1);
        }
    }

    public void setLevel(int level) {
        this.level = level;
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
        if (hitPoints <= 0)
            hitPoints = 0;
        this.hitPoints = hitPoints;
        if (this.hitPoints <= 0)
            setAlive(false);
    }

    public String getHeroName() {
        return heroName;
    }

    public Boolean getAlive() {
        return alive;
    }

    public int getHeroClass() {
        return heroClass;
    }

    public int getWeapon() {
        return weapon;
    }

    public int getArmor() {
        return armor;
    }

    public int getHelm() {
        return helm;
    }

    public int getXP() {
        return XP;
    }

    public int getLevel() {
        return level;
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
