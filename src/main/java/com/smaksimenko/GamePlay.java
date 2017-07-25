package com.smaksimenko;


import com.smaksimenko.entities.Army;
import com.smaksimenko.entities.Character;
import com.smaksimenko.enums.Race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GamePlay {

    Army army1;
    Army army2;

    Out log = new Out();

    public static void main(String[] args) {
        GamePlay gamePlay = new GamePlay();
        gamePlay.createArmies();
        gamePlay.play();

    }

    public void createArmies() {
        //random choice of race
        int randomRace1 = (int) (Math.random() * 2);
        int randomRace2 = (int) (Math.random() * 2) + 2;

        //create armies
        army1 = new Army(Race.values()[randomRace1], log);
        army2 = new Army(Race.values()[randomRace2], log);
        army1.setEnemyArmy(army2);
        army2.setEnemyArmy(army1);
        army1.createArmy();
        army2.createArmy();

        log.log("В битве учавствуют: " + army1.getRace().getName() + " и " + army2.getRace().getName());
    }

    public void play() {

        //who make first move
        int firstMove = (int) (Math.random() * 2);

        while (!army1.isDestroyed() && !army2.isDestroyed()) {
            if (firstMove == 0) {
                goAttack(army1, army2);
            } else {
                goAttack(army2, army1);
            }
        }
        //determine the winner
        if (army1.isDestroyed())
            log.log("Армия " + army2.getRace().getName() + " одержала победу");
        if (army2.isDestroyed())
            log.log("Армия " + army1.getRace().getName() + " одержала победу");

        log.logToFile(army1, army2);

    }

    private void goAttack(Army army1, Army army2) {

        // create groups by priority
        List<Character> privileged1 = new ArrayList<>();
        List<Character> common1 = new ArrayList<>();
        List<Character> privileged2 = new ArrayList<>();
        List<Character> common2 = new ArrayList<>();


        groupByPriority(army1, privileged1, common1);

        //mix characters randomly
        Collections.shuffle(privileged1);
        Collections.shuffle(common1);

        log.log("-----------Ход отряда " + army1.getRace().getName() + "--------------");
        //attack from first army
        for (Character character : privileged1)
            character.attack();
        for (Character character : common1)
            character.attack();

        groupByPriority(army2, privileged2, common2);

        //mix characters randomly
        Collections.shuffle(privileged2);
        Collections.shuffle(common2);
        log.log("-----------Ход отряда " + army2.getRace().getName() + "--------------");

        //attack from second army
        for (Character character : privileged2)
            character.attack();
        for (Character character : common2)
            character.attack();
    }

    private void groupByPriority(Army army, List<Character> privileged, List<Character> common) {
        for (Character character : army.getCharacters()) {
            if (character.isPrivileged()) {
                privileged.add(character);
            } else common.add(character);
        }
    }


}
