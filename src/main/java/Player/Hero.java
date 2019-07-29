package Player;

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
    protected int Experience;
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
            setDefense(1);
            setAttack(12);
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
        this.XP = xp;
        if (this.XP == (this.level + 1) * 1000 + (((this.level + 1) - 1)*((this.level + 1) - 1))*450) {
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

    public void setExperience(int experience) {
        Experience = experience;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public void setDefense(int defense) {
        Defense = defense;
    }

    public void setHitPoints(int hitPoints) {
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

    public int getExperience() {
        return Experience;
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
