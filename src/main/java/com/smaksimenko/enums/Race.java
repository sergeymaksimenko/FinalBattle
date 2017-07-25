package com.smaksimenko.enums;

public enum Race {
    HUMANS("Люди"),
    ELF("Эльфы"),
    ORK("Орки"),
    UNDEAD("Нежить");

    private String name;

    Race(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
