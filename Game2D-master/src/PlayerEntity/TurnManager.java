package main;

import PlayerEntity.PlayerEntity;

public class TurnManager {
    private int currentPlayerIndex;
    private PlayerEntity[] players;

    public TurnManager(PlayerEntity[] players) {
        this.players = players;
        currentPlayerIndex = 0;
    }

    public boolean isPlayerTurn(PlayerEntity player) {
        return players[currentPlayerIndex].equals(player);
    }

    public void endTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }
}
