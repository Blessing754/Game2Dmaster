package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// KeyHandler class to handle keyboard inputs for the game
public class KeyHandler implements KeyListener {

    // Flags for Player 1's movement direction
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    // Internal flags to prevent continuous movement when a key is held down
    private boolean canMoveUp = true, canMoveDown = true, canMoveLeft = true, canMoveRight = true;

    // Flag for another action (e.g., reload, respawn) for Player 1
    public boolean rPressed;

    // Flags for Player 2's movement direction
    public boolean wPressed, sPressed, aPressed, dPressed;

    // Internal flags for Player 2 to prevent continuous movement when a key is held down
    private boolean canMoveW = true, canMoveS = true, canMoveA = true, canMoveD = true;

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used in this implementation, but required by KeyListener interface
        // It's triggered when a key is typed (press and release together)
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();  // Retrieves the code of the key pressed

        // Checks and updates flags for Player 1's movement
        if (code == KeyEvent.VK_UP && canMoveUp) { upPressed = true; canMoveUp = false; }
        if (code == KeyEvent.VK_DOWN && canMoveDown) { downPressed = true; canMoveDown = false; }
        if (code == KeyEvent.VK_LEFT && canMoveLeft) { leftPressed = true; canMoveLeft = false; }
        if (code == KeyEvent.VK_RIGHT && canMoveRight) { rightPressed = true; canMoveRight = false; }

        // Checks and updates flags for Player 2's movement
        if (code == KeyEvent.VK_W && canMoveW) { wPressed = true; canMoveW = false; }
        if (code == KeyEvent.VK_S && canMoveS) { sPressed = true; canMoveS = false; }
        if (code == KeyEvent.VK_A && canMoveA) { aPressed = true; canMoveA = false; }
        if (code == KeyEvent.VK_D && canMoveD) { dPressed = true; canMoveD = false; }

        // Check for other key actions (e.g., R key for reload or respawn)
        if (code == KeyEvent.VK_R) { rPressed = true; }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();  // Retrieves the code of the key released

        // Resets flags upon releasing the keys for Player 1
        if (code == KeyEvent.VK_UP) { upPressed = false; canMoveUp = true; }
        if (code == KeyEvent.VK_DOWN) { downPressed = false; canMoveDown = true; }
        if (code == KeyEvent.VK_LEFT) { leftPressed = false; canMoveLeft = true; }
        if (code == KeyEvent.VK_RIGHT) { rightPressed = false; canMoveRight = true; }

        // Resets flags upon releasing the keys for Player 2
        if (code == KeyEvent.VK_W) { wPressed = false; canMoveW = true; }
        if (code == KeyEvent.VK_S) { sPressed = false; canMoveS = true; }
        if (code == KeyEvent.VK_A) { aPressed = false; canMoveA = true; }
        if (code == KeyEvent.VK_D) { dPressed = false; canMoveD = true; }

        // Resets the R key flag
        if (code == KeyEvent.VK_R) { rPressed = false; }
    }
}
