package org.example;


public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
        System.out.println(game);
        System.out.println(game.getBots().toString());
    }
}