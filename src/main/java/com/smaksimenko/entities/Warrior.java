package com.smaksimenko.entities;

import com.smaksimenko.Out;
import com.smaksimenko.entities.Army;
import com.smaksimenko.entities.Character;
import com.smaksimenko.enums.Warriors;

public class Warrior extends com.smaksimenko.entities.Character {
    private double damage;
    private String attackText;


    public Warrior(String name, Warriors warrior, Army army, Out log) {
        super(name, army, log);
        this.damage = warrior.getDamage();
        this.attackText = warrior.getAttackText();
    }

    @Override
    public void attack() {

        //if the enemy army already destroyed
        if (getEnemyArmy().isDestroyed())
            return;

        //Get random character from enemy army

        Character enemy = getRandomEnemy();

        getLog().log("Отряд " + getRace().getName() + ". " + getName() + " " + attackText + enemy.getName());

        // Attack the enemy
        double dam = damage;
        //checking for curse
        if (isCurse()) {
            setPrivileged(false);
            dam = damage / 2.0;
        }
        //if character is privileged, then increase damage
        if (isPrivileged())
            dam = damage * 1.5;
        enemy.getDamage(dam);
        setPrivileged(false);
        setCurse(false);
    }
}
