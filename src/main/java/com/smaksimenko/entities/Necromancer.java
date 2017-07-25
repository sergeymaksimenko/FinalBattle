package com.smaksimenko.entities;

import com.smaksimenko.Out;
import com.smaksimenko.enums.Magicians;

public class Necromancer extends Magician {
    public Necromancer(String name, Magicians magician, Army army, Out log) {
        super(name, magician, army, log);
    }

    @Override
    protected void enhanceFriend() {

        //if the enemy army already destroyed
        if (getEnemyArmy().isDestroyed())
            return;

        //Get random character from enemy army
        Character enemy = getRandomEnemy();

        getLog().log("Отряд " + getRace().getName() + ". " + getName() + " " + " насылает недуг " + enemy.getName());

        // Attack the enemy
        enemy.setCurse(true);
    }
}

