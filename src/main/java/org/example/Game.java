package org.example;

import org.example.Structures.Implementations.LinkedQueue;

import java.util.Scanner;

public class Game {
    private GameMap gameMap;
    private Player player1;
    private Player player2;

    private LinkedQueue<Bot> bots;

    public Game() {
        this.gameMap = new GameMap();
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
        this.bots = new LinkedQueue<>();
    }

    public void startGame() {
        String file = null;
        Scanner scanner = new Scanner(System.in);

        // Ask the user whether to create a new map or import an existing one
        System.out.println("Do you want to create a new map (1) or import an existing one (2)?");
        int choice = scanner.nextInt();

        if (choice == 1) {
            createNewMap();
        } else if (choice == 2) {
            this.gameMap.importMap(file);
        } else {
            System.out.println("Invalid option. Exiting the game.");
            return;
        }

        // Select bases for the players
        player1.selectBase(gameMap, player2);
        player2.selectBase(gameMap, player1);

        // Display information about the players and the map (for testing purposes)
        System.out.println("\n" + player1.toString());
        System.out.println(player2.toString());
        System.out.println(gameMap.toString());
    }

    private void createNewMap() {
        System.out.println("Creating a new map...");

        int quantityLocations = getInputAsInt("Enter the number of locations: ");
        boolean bidirectional = getInputAsBoolean("Should the map be bidirectional? (true/false): ");
        double densityEdges = getInputAsDouble("Enter the density of edges (between 0 and 1): ");

        gameMap = gameMap.generateRandomMap(quantityLocations, bidirectional, densityEdges);
    }

    private int getInputAsInt(String message) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        boolean validInput = false;

        do {
            System.out.print(message);
            try {
                input = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        } while (!validInput);

        return input;
    }

    private boolean getInputAsBoolean(String message) {
        Scanner scanner = new Scanner(System.in);
        boolean input = false;
        boolean validInput = false;

        do {
            System.out.print(message);
            String inputString = scanner.nextLine().toLowerCase();
            if (inputString.equals("true") || inputString.equals("false")) {
                input = Boolean.parseBoolean(inputString);
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        } while (!validInput);

        return input;
    }

    private double getInputAsDouble(String message) {
        Scanner scanner = new Scanner(System.in);
        double input = 0;
        boolean validInput = false;

        do {
            System.out.print(message);
            try {
                input = Double.parseDouble(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid double.");
            }
        } while (!validInput);

        return input;
    }

    @Override
    public String toString() {
        return this.gameMap.toString();
    }
}