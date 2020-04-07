package com.pogorelov.stonegame;

public class EasyComputer extends Computer {

    @Override
    int makeTurn(int stonesQuantity) {
        int stones = (int) (Math.random() * 3 + 1);
        System.out.println("Computer's turn. Computer has chosen " + stones + " stones");
        return stones;
    }
}
