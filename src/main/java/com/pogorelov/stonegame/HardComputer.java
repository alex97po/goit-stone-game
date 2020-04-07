package com.pogorelov.stonegame;

public class HardComputer extends Computer {

    @Override
    int makeTurn(int stonesQuantity) {
        int stones = stonesQuantity % 4 == 0 ? (int) (Math.random() * 3 + 1) : stonesQuantity % 4;
        System.out.println("Computer's turn. Computer has chosen " + stones + " stones");
        return stones;
    }
}
