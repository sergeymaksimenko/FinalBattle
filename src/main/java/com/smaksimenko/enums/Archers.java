package com.smaksimenko.enums;

public enum Archers {
    Arbalester("Арбалетчик", Race.HUMANS, 3.0, 5.0, " атакует ", " стреляет из арбалета в "),
    ElfArcher("Лучник", Race.ELF, 3.0, 7.0, " атакует ", "стреляет из лука в "),
    OrkArcher("Лучник", Race.ORK, 2.0, 3.0, " ударяет клинком ", " стреляет из лука в "),
    Hunter("Охотник", Race.UNDEAD, 2.0, 4.0, " атакует ", " стреляет из лука в ");

    private String name;
    private Race race;
    private double damage;
    private double damageByArrows;
    private String attackText;
    private String attackArrowsText;

    Archers(String name, Race race, double damage, double damageByArrows, String attackText, String attackArrowsText) {
        this.name = name;
        this.race = race;
        this.damage = damage;
        this.damageByArrows = damageByArrows;
        this.attackText = attackText;
        this.attackArrowsText = attackArrowsText;
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

    public double getDamageByArrows() {
        return damageByArrows;
    }

    public String getAttackText() {
        return attackText;
    }

    public String getAttackArrowsText() {
        return attackArrowsText;
    }
}
