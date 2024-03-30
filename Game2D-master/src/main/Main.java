package main;  // Declares a package named 'main', used for organizing files and classes

import javax.swing.JFrame;  // Imports the JFrame class from the javax.swing package

// Declares a public class named Main. Public classes are accessible from other classes.
public class Main {

    // The main method is the entry point for any Java application.
    public static void main(String[] args) {

        // Creates a new instance of JFrame. JFrame is used for creating a window with a title bar, border, and controls.
        JFrame window = new JFrame();

        // Sets the default operation when the window is closed to exit the application.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Disables the resizing feature of the window.
        window.setResizable(false);

        // Sets the title of the window to "MY game".
        window.setTitle("MY game");

        // Creates a new instance of GamePanel, presumably a custom class for the game's main panel.
        GamePanel gamePanel = new GamePanel();

        // Adds the GamePanel instance to the window.
        window.add(gamePanel);

        // Calls a method to set up the game. This is likely a custom method in the GamePanel class.
        gamePanel.setupGame();

        // Starts the game thread. This is likely a method in the GamePanel class that initiates the game loop or logic.
        gamePanel.startGameThread();

        // Adjusts the window size to fit the preferred size and layouts of its subcomponents.
        window.pack();

        // Centers the window in relation to the screen.
        window.setLocationRelativeTo(null);

        // Makes the window visible. Before this call, it would not be shown.
        window.setVisible(true);
    }
}
