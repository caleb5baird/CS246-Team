package cBaird;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private int health;
    private int mana;
    private int gold;
    private HashMap<String, Integer> equipment;

    public Player(String name, int health, int mana, int gold) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.gold = gold;
        equipment = new HashMap<String, Integer>();
    }

    public void display() {
        System.out.println(name + health + mana + gold);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getGold() {
        return gold;
    }

    public void addEquipment(String item, Integer cost) {
        equipment.put(item, cost);
    }

    public void setName(String name) {
       this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
