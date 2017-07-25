package com.smaksimenko.entities;

import com.smaksimenko.Out;
import com.smaksimenko.enums.Archers;
import com.smaksimenko.enums.Magicians;
import com.smaksimenko.enums.Race;
import com.smaksimenko.enums.Warriors;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Army {
    private Race race;
    private List<Character> characters;
    private Out log;
    private Army enemyArmy;


    public Army(Race race, Out log) {
        this.race = race;
        this.log = log;
        characters = new ArrayList<>();
    }

    private Warrior createWarrior(String name, Warriors warrior) {
        return new Warrior(name, warrior, this, log);
    }

    private Archer createArcher(String name, Archers archer) {
        return new Archer(name, archer, this, log);
    }

    private Magician createMagician(String name, Magicians magician) {
        Magician mag = null;
        //create magician race we needed
        try {
            mag = magician.getClazz().getDeclaredConstructor(String.class, Magicians.class, Army.class, Out.class).newInstance(name, magician, this, log);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return mag;
    }

    public void createArmy() {
        Magicians magicians = getMagicianByRace(race);
        Warriors warriors = getWarriorByRace(race);
        Archers archers = getArcherByRace(race);

        //create magician
        characters.add(createMagician(magicians.getName(), getMagicianByRace(race)));

        //create archers
        for (int i = 1; i < 4; i++) {
            characters.add(createArcher(archers.getName() + " " + i, getArcherByRace(race)));
        }

        //create warriors
        for (int i = 1; i < 5; i++) {
            characters.add(createWarrior(warriors.getName() + " " + i, getWarriorByRace(race)));
        }
    }

    //get warrior instance from enum
    private Warriors getWarriorByRace(Race race) {
        Warriors warriors = null;
        for (Warriors tmp : Warriors.values()) {
            if (tmp.getRace() == race)
                warriors = tmp;
        }
        return warriors;
    }
    //get magician instance from enum
    private Magicians getMagicianByRace(Race race) {
        Magicians magicians = null;
        for (Magicians tmp : Magicians.values()) {
            if (tmp.getRace() == race)
                magicians = tmp;
        }
        return magicians;
    }
    //get archer instance from enum
    private Archers getArcherByRace(Race race) {
        Archers archers = null;
        for (Archers tmp : Archers.values()) {
            if (tmp.getRace() == race)
                archers = tmp;
        }
        return archers;
    }

    public boolean isDestroyed() {
        return (characters.size() == 0);
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public Race getRace() {
        return race;
    }

    public Army getEnemyArmy() {
        return enemyArmy;
    }

    public void setEnemyArmy(Army enemyArmy) {
        this.enemyArmy = enemyArmy;
    }
}
