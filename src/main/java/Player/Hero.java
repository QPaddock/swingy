package Player;

public class Hero {
    private String heroName;
    private int heroClass;
    private int weapon;
    private int armor;
    private int helm;
    private int XP;
    private int level;
    protected int Experience;
    protected int Attack;
    protected int Defense;
    protected int hitPoints;

    public Hero(String name, int cls) {
        setHeroName(name);
        setHeroClass(cls);
        setXP(0);
        setLevel(0);
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
        System.out.printf("Hit Points = %d\nAttack = %d\nDefense = %d", getHitPoints(), getAttack(), getDefense());
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
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
    }

    public void setLevel(int level) {
        this.level = level;
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
    }

    public String getHeroName() {
        return heroName;
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
