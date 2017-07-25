package com.smaksimenko.entities;

import com.smaksimenko.Out;
import com.smaksimenko.enums.Magicians;

public class HumanMagician extends Magician {
    public HumanMagician(String name, Magicians magician, Army army, Out log) {
        super(name, magician, army, log);
    }
}
