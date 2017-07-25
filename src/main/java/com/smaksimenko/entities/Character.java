package com.smaksimenko.entities;

import com.smaksimenko.Out;
import com.smaksimenko.enums.Race;
import com.smaksimenko.interfaces.AbleToAttack;

public abstract class Character implements AbleToAttack {
    private double health = 100.0;
    private String name;
    private Race race;
    private boolean privileged;
    private boolean curse;
    private Army myArmy;
    private Out log;

    public Character(String name, Army army, Out log) {
        this.name = name;
        myArmy = army;
        this.log = log;
        race = myArmy.getRace();
    }

    //get damage from enemy
    public void getDamage(double damage) {
        health = health - damage;
        if (health < 0)
            health = 0;
        log.log("Отряд " + myArmy.getRace().getName() + " " + name + " получает урон " + damage + ". Остаток здоровья - " + health);
        if (health == 0) {
            log.log("Отряд " + myArmy.getRace().getName() + " " + name + " уничтожен. Аминь.");
            myArmy.getCharacters().remove(this);
            log.log("В отряде " + myArmy.getRace().getName() + " осталось " + myArmy.getCharacters().size() + " войнов.");
        }
    }


    public Army getEnemyArmy() {
        return myArmy.getEnemyArmy();
    }

    public Out getLog() {
        return log;
    }

    public Race getRace() {
        return race;
    }

    public String getName() {
        return name;
    }

    public boolean isPrivileged() {
        return privileged;
    }

    public Character getRandomEnemy() {
        return getEnemyArmy().getCharacters().get((int) (Math.random() * getEnemyArmy().getCharacters().size()));
    }

    public Character getRandomFriend() {
        return myArmy.getCharacters().get((int) (Math.random() * myArmy.getCharacters().size()));
    }

    public void setPrivileged(boolean privileged) {
        this.privileged = privileged;
    }

    public void setCurse(boolean curse) {
        this.curse = curse;
        if (curse)
            setPrivileged(false);
    }

    public boolean isCurse() {
        return curse;
    }

}
