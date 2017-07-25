package com.smaksimenko.enums;


public enum Warriors {
    HumanWarrior("Воин",Race.HUMANS, 18.0, " атакует мечом "),
    ElfWarrior("Воин",Race.ELF, 15.0, " атакует мечом "),
    Goblin("Гоблин",Race.ORK, 20.0, " наносит удар дубиной "),
    Zombie("Зомби",Race.UNDEAD, 18.0, " наносит удар копьем ");

    private String name;
    private double damage;
    private String attackText;
    private Race race;

    Warriors(String name, Race race,double damage, String attackText) {
        this.name = name;
        this.damage = damage;
        this.attackText = attackText;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public double getDamage() {
        return damage;
    }

    public String getAttackText() {
        return attackText;
    }

    public Race getRace() {
        return race;
    }
}
