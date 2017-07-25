package com.smaksimenko.enums;


import com.smaksimenko.entities.Magician;

public enum Magicians {

    HumanMagician("Маг",Race.HUMANS, 4.0, " атакует магией ", com.smaksimenko.entities.HumanMagician.class),
    ElfMagician("Маг",Race.ELF, 10.0, " наносит урон магией ", com.smaksimenko.entities.ElfMagician.class),
    Shaman("Шаман",Race.ORK, 0, " накладывает проклятие на ", com.smaksimenko.entities.Shaman.class),
    Necromancer("Некромант",Race.UNDEAD, 5, " атакует магией ", com.smaksimenko.entities.Necromancer.class);

    String name;
    Race race;
    double damage;
    String attackText;
    Class<? extends Magician> clazz;

    Magicians(String name, Race race, double damage, String attackText, Class<? extends Magician> clazz) {
        this.name = name;
        this.race = race;
        this.damage = damage;
        this.attackText = attackText;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public double getDamage() {
        return damage;
    }

    public String getAttackText() {
        return attackText;
    }

    public Class<? extends Magician> getClazz() {
        return clazz;
    }
}
