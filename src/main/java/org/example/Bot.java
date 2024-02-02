package org.example;

public class Bot {
    private Strategy strategy;
    private String playerName;

    public Bot(Strategy strategy, String playerName) {
        this.strategy = strategy;
        this.playerName = playerName;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeMovement() {
        if (strategy != null) {
            strategy.executeMovement();
        }
    }
}
