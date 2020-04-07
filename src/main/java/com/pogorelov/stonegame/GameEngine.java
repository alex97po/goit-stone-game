package com.pogorelov.stonegame;

import java.util.Scanner;

public class GameEngine {

    private int stoneQuantity = 15;
    private final Scanner scanner = new Scanner(System.in);

    public void launchGame() {
        System.out.println("Hello! Welcome in our game.");
        System.out.println("Press \"q\" anytime you want to finish game");
        System.out.println("Levels: 1. Easy; 2. Hard");
        System.out.print("Type level number: ");
        int chosenLevel = getValidatedInput("^[1-2]$");
        Computer computer = ComputerFactory.getComputerByLevel(chosenLevel);
        proceedGame(computer);
    }

    private void proceedGame(Computer computer) {
        while (stoneQuantity > 0) {
            System.out.println("Stones remain: " + stoneQuantity);
            stoneQuantity -= makeTurn();
            if (stoneQuantity <= 0) {
                System.out.println("PLAYER WIN!!!!");
                break;
            }
            stoneQuantity -= computer.makeTurn(stoneQuantity);
            if (stoneQuantity <= 0) {
                System.out.println("COMPUTER WIN!!!!!");
                break;
            }
        }
        if (restartGame()) {
            stoneQuantity = 15;
            launchGame();
        }
    }

    private boolean restartGame() {
        System.out.println("Do you want to play one more time?");
        System.out.print("1. Yes; 2. No. Print number: ");
        int needToRestart = getValidatedInput("^[1-2]$");
        return needToRestart == 1;
    }

    private int makeTurn() {
        System.out.print("Your turn. Choose from 1 to 3 stones (type number): ");
        return getValidatedInput("^[1-3]$");
    }

    private int getValidatedInput(String regex) {
        String input = scanner.next();
        if (input.equalsIgnoreCase("q")) {
            System.out.println("Bye-bye!");
            System.exit(0);
        }
        while (!input.matches(regex)) {
            if (input.equalsIgnoreCase("q")) {
                System.out.println("Bye-bye!");
                System.exit(0);
            }
            System.out.print("Wrong input! Try again: ");
            input = scanner.next();
        }
        return Integer.parseInt(input);

    }

}
