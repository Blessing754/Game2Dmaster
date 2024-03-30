
package PlayerEntity;

import java.awt.*;
import javax.swing.*;

public class Scoreboard extends JPanel {
    private final PlayerEntity player; // Use the PlayerEntity interface
    private final PlayerEntity player2;
    private long startTime;
    private long elapsedTime; // in milliseconds
    private String questItem;
    private String currentPlayerTurn;

    public Scoreboard(PlayerEntity player, PlayerEntity player2) {
        this.player = player;
        this.player2 = player2;
        this.startTime = System.currentTimeMillis();
        this.setLayout(new GridLayout(0, 1)); // Set layout of the scoreboard
        updateDisplay();
    }

    // Call this method to refresh and update the scoreboard display
    public void updateDisplay() {
        this.removeAll(); // Clear the previous content
        elapsedTime = System.currentTimeMillis() - startTime;
        add(new JLabel("Elapsed Time: " + elapsedTime / 1000 + " seconds"));
        add(new JLabel("Current Player's Turn: " + currentPlayerTurn));
        add(new JLabel("Quest Item: " + questItem));
        addPlayerDetails(player, "Player 1");
        addPlayerDetails(player2, "Player 2");
        this.revalidate();
        this.repaint();
    }

    // Helper method to add player details to the scoreboard
    private void addPlayerDetails(PlayerEntity player, String playerLabel) {
        add(new JLabel(playerLabel + " Score: " + player.getScore()));
        add(new JLabel(playerLabel + " Money: " + player.getMoney()));
        add(new JLabel(playerLabel + " Power: " + player.getPower()));
        add(new JLabel(playerLabel + " Found Treasures: " + player.getFoundTreasures()));
    }

    // Setters for updating game state information
    public void setCurrentPlayerTurn(String currentPlayerTurn) {
        this.currentPlayerTurn = currentPlayerTurn;
        updateDisplay();
    }

    public void setQuestItem(String questItem) {
        this.questItem = questItem;
        updateDisplay();
    }

    // Example method to simulate interaction (e.g., mouse click on the scoreboard)
    public void onScoreboardClick() {
        // Display scoreboard in a dialog or another suitable component
        JOptionPane.showMessageDialog(null, this, "Scoreboard", JOptionPane.INFORMATION_MESSAGE);
    }
}
