package PlayerEntity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerEntity {
    // Attributes
    public int worldX, worldY;
    public int speed;
    public BufferedImage up1, up2, up3, up4, down1, down2, down3, down4, left1, left2, left3, left4,
            right1, right2, right3, right4;
    public BufferedImage
            up1_p2, up2_p2, up3_p2, up4_p2, up5_p2, up6_p2, up7_p2, up8_p2, up9_p2, // Up
            down1_p2, down2_p2, down3_p2, down4_p2, down5_p2, down6_p2, down7_p2, down8_p2, down9_p2, // Down
            left1_p2, left2_p2, left3_p2, left4_p2, left5_p2, left6_p2, left7_p2, left8_p2, left9_p2, // Left
            right1_p2, right2_p2, right3_p2, right4_p2, right5_p2, right6_p2, right7_p2, right8_p2, right9_p2; // Right
    public String direction;
    public int targetX, targetY;
    public boolean moving = false;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public int solidAreaDX, solidAreaDY;
    public boolean collisionOn = false;

    private int health;
    private int money;
    private int power;
    private int startingX, startingY; // Starting position
    private String name;
    private int score;
    private int foundTreasures;
    // Constructor
    public PlayerEntity(String name, int startingX, int startingY) {
        this.name = name;
        this.startingX = startingX;
        this.startingY = startingY;
        this.health = 100; // Default health value
        this.money = 500; // Default money value
        this.power = 10;  // Default power value
        // Initialize other attributes as necessary
    }

    public PlayerEntity(int startX, int startY, int startSpeed) {
        // Set starting positions and speed
        worldX = startX;
        worldY = startY;
        speed = startSpeed;
        // Initialize other fields as needed
    }

    // No-argument constructor
    public PlayerEntity() {
        // Call parameterized constructor with default values
        this(0, 0, 0); // Default positions (0,0) and speed of 0
    }

    // Getters and Setters
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    public int getScore() {return score;}

    public void setScore(int score) {this.score =score;}

    public int getFoundTreasures() {return foundTreasures;}

    public void setFoundTreasures(int foundTreasures) {this.foundTreasures = foundTreasures;}

    public void resetPosition() {
        this.worldX = startingX;
        this.worldY = startingY;
        // Reset other movement-related attributes as needed
    }

    public String getName() {
        return name;
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    // You may also want to implement a method to update the player's sprite based on direction and movement


    // Implement methods to draw the player and handle other logic as needed.
}
