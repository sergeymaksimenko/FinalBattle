package com.smaksimenko.entities;

import com.smaksimenko.Out;
import com.smaksimenko.entities.Army;
import com.smaksimenko.entities.Character;
import com.smaksimenko.enums.Magicians;

public abstract class Magician extends com.smaksimenko.entities.Character {
    private double damage;
    private String attackText;

    public Magician(String name, Magicians magician, Army army, Out log) {
        super(name, army, log);
        this.damage = magician.getDamage();
        this.attackText = magician.getAttackText();
    }

    @Override
    public void attack() {
        if ((int) (Math.random() * 2) == 0)
            enhanceFriend();
        else attackEnemy();
    }

    protected void attackEnemy() {
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

    protected void enhanceFriend() {
        Character friend = getRandomFriend();
        getLog().log("Отряд " + getRace().getName() + ". " + getName() + " накладывает улучшение на " + friend.getName());
        friend.setPrivileged(true);
        setPrivileged(false);
        setCurse(false);
    }

    public String getAttackText() {
        return attackText;
    }
}
