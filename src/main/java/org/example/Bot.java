package org.example;

public class Bot {
    private StrategiesType strategy;
    private String playerName;

    public Bot(StrategiesType strategy, String playerName) {
        this.strategy = strategy;
        this.playerName = playerName;
    }

    public StrategiesType getStrategy() {
        return strategy;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setStrategy(StrategiesType strategy) {
        this.strategy = strategy;
    }

    public void executeMovement() {
        if (strategy != null) {

        }
    }

    @Override
    public String toString() {
        return "Bot: " +
                "\n Strategy - " + strategy +
                "\n Assigned to - " + playerName + '\n';
    }
}
