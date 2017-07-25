package com.smaksimenko.entities;


import com.smaksimenko.Out;
import com.smaksimenko.enums.Archers;

public class Archer extends Character {
    private double damage;
    private double damageByArrows;
    private String attackText;
    private String attackArrowsText;

    public Archer(String name, Archers archer, Army army, Out log) {
        super(name, army, log);
        this.damage = archer.getDamage();
        this.damageByArrows = archer.getDamageByArrows();
        this.attackText = archer.getAttackText();
        this.attackArrowsText = archer.getAttackArrowsText();
    }

    @Override
    public void attack() {
        if ((int) (Math.random() * 2) == 0)
            attackArrows();
        else attackEnemy();
    }

    private void attackEnemy() {
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

    private void attackArrows() {

        //if the enemy army already destroyed
        if (getEnemyArmy().isDestroyed())
            return;

        //Get random character from enemy army

        Character enemy = getRandomEnemy();

        getLog().log("Отряд " + getRace().getName() + ". " + getName() + " " + attackArrowsText + enemy.getName());
        // Attack the enemy
        double dam = damageByArrows;
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
