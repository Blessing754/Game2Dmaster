package PlayerEntity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.util.Random;

public class Player extends PlayerEntity {

    public int screenX;
    public int screenY;
    private int stepsRemaining;
    private int score;
    private int power;

    private int foundTreasures;

    private int money; // Add money property
    private int strength; // Add strength property
    private int startingX = 768; // Your starting X, assuming it's a constant
    private int startingY = 384; // Your starting Y, assuming it's a constant
    private Dice dice;

    GamePanel gp;
    KeyHandler keyH;
    int sword=0;

    int hasKey=0;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money += money;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power += power;
    }

    public int getFoundTreasures() {
        return foundTreasures;
    }

    public void addFoundTreasure() {
        this.foundTreasures++;
    }

    public Player(GamePanel gp, KeyHandler keyH, int health, int money, int power) {
        super(health, money, power);
        this.gp = gp;
        this.keyH = keyH;

        solidArea = new Rectangle();
        solidArea.x=8;
        solidArea.y=16;
        solidArea.width=48;
        solidArea.height=48;

        solidAreaDX= solidArea.x;
        solidAreaDY= solidArea.y;

        dice = new Dice();

        setDefaultValues();
        getPlayerImage();

        this.money = 100; // Initialize with some money
        this.strength = 10; // Initialize with some strength
    }



    public void setDefaultValues() {

        worldX = 768;
        worldY = 384;
        speed = 2;
        direction = null;
    }

    public void getPlayerImage() {

        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/back0.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/back1.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/back2.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/back3.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/player/fron0.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/fron1.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/fron2.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/fron3.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/left0.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/left3.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/player/right0.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/right3.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (gp.turnManager.isPlayerTurn(this) && !moving) {
            // Player must press 'R' to roll the dice if steps are 0.
            if (stepsRemaining == 0 && keyH.rPressed) {
                stepsRemaining = dice.roll();
                System.out.println("Dice rolled: " + stepsRemaining + " steps.");
                keyH.rPressed = false; // Reset the dice roll flag to prevent multiple rolls in one turn.
            }

            // Proceed with the movement if the dice has been rolled.
            if (stepsRemaining > 0 && (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed)) {
                setDirectionAndTargetPosition();

                collisionOn = gp.cChecker.checkTileCollision(this, targetX, targetY);
                if (!collisionOn) {
                    moving = true;
                    stepsRemaining--; // Decrement steps after each move
                }

                // Reset movement keys to prevent continuous movement
                if (keyH.upPressed) keyH.upPressed = false;
                if (keyH.downPressed) keyH.downPressed = false;
                if (keyH.leftPressed) keyH.leftPressed = false;
                if (keyH.rightPressed) keyH.rightPressed = false;

                // End the player's turn if they have no more steps to move
                if (stepsRemaining == 0) {
                    gp.turnManager.endTurn();
                }
            }
        }

        // If in motion, continue moving towards the target
        if (moving) {
            moveTowardsTarget();
            updateAnimation();
        }

        // Check for object interactions
        int objIndex = gp.cChecker.checkObject(this, true);
        pickUpObject(objIndex);
    }


    public void pickUpObject(int i) {
        if (i != 999) {
            String ObjectName = gp.obj[i].name;

            switch(ObjectName){
                case "Key":
                    hasKey++;
                    gp.obj[i] = null;
                    System.out.println("key:"+hasKey);
                    break;

                case "Castle" :
                    if (hasKey >= 3){
                        gp.obj[i] = null;
                        hasKey--;
                    }
                    System.out.println("key:"+hasKey);

                    break;


//                case "sword":
//                    sword++;
//                    gp.obj[i] = null;
//                    System.out.println("sword:"+sword);
//                    break;
            }
        }
    }

    private void setDirectionAndTargetPosition() {
        int tileSize = gp.tileSize;

        if (keyH.upPressed) {
            direction = "up";
            targetX = worldX;
            targetY = worldY - tileSize;
        } else if (keyH.downPressed) {
            direction = "down";
            targetX = worldX;
            targetY = worldY + tileSize;
        } else if (keyH.leftPressed) {
            direction = "left";
            targetX = worldX - tileSize;
            targetY = worldY;
        } else if (keyH.rightPressed) {
            direction = "right";
            targetX = worldX + tileSize;
            targetY = worldY;
        }
    }

    private void moveTowardsTarget() {
        if (Math.abs(targetX - worldX) > speed) {
            worldX += speed * (targetX > worldX ? 1 : -1);
        } else {
            worldX = targetX;
        }

        if (Math.abs(targetY - worldY) > speed) {
            worldY += speed * (targetY > worldY ? 1 : -1);
        } else {
            worldY = targetY;
        }

        // Stop moving when the target is reached
        if (worldX == targetX && worldY == targetY) {
            moving = false;
        }
    }
    private void updateAnimation() {
        // Your sprite animation update logic here
        spriteCounter++;
        if (spriteCounter > 7) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 3;
            } else if (spriteNum == 3) {
                spriteNum = 4;
            } else if (spriteNum == 4) {
                spriteNum = 1;
            }
            spriteCounter = 0;

        }
    }




    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        if (direction != null) {

            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    else if (spriteNum == 2) {
                        image = up2;
                    }
                    else if (spriteNum == 3) {
                        image = up3;
                    }
                    else if (spriteNum == 4) {
                        image = up4;
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    else if (spriteNum == 2) {
                        image = down2;
                    }
                    else if (spriteNum == 3) {
                        image = down3;
                    }
                    else if (spriteNum == 4) {
                        image = down4;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    else if (spriteNum == 2) {
                        image = left2;
                    }
                    else if (spriteNum == 3) {
                        image = left3;
                    }
                    else if (spriteNum == 4) {
                        image = left4;
                    }

                    break;
                case "right":
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    else if (spriteNum == 2) {
                        image = right2;
                    }
                    else if (spriteNum == 3) {
                        image = right3;
                    }
                    else if (spriteNum == 4) {
                        image = right4;
                    }
                    break;
            }
        }
        if (image == null) {
            image = down1_p2; // Default image
        }
        g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
    }
}