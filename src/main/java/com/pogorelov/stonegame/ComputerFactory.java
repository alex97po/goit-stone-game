package com.pogorelov.stonegame;

public class ComputerFactory {

    public static Computer getComputerByLevel(int level) {
        switch (level) {
            case 1: return new EasyComputer();
            case 2: return new HardComputer();
            default: return null;
        }
    }
}
