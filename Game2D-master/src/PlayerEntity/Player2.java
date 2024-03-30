package PlayerEntity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player2 extends PlayerEntity {

    GamePanel gp;
    KeyHandler keyH;
    private int stepsRemaining;
    private Dice dice;
    int hasKeyP2 = 0;
    int swordP2=0;
private int score2;
private int foundTreasures2;

private int power2;

private int money2;

    public Player2(GamePanel gp, KeyHandler keyH, int health, int money, int power) {
        super(health, money, power);
        this.gp = gp;
        this.keyH = keyH;

        solidArea = new Rectangle();
        solidArea.x=8;
        solidArea.y=16;
        solidArea.width=48;
        solidArea.height=48;


        dice = new Dice();
        setDefaultValuesP2();
        getPlayerImageP2();
        getPlayerImageP2();
    }

    public int getScore() {
        return score2;
    }

    public void setScore(int score2) {
        this.score2 += score2;
    }

    public int getMoney() {
        return money2;
    }

    public void setMoney(int money) {
        this.money2 += money2;
    }

    public int getPower() {
        return power2;
    }

    public void setPower(int power) {
        this.power2 += power2;
    }

    public int getFoundTreasures() {
        return foundTreasures2;
    }

    public void addFoundTreasure() {
        this.foundTreasures2++;
    }
    public void setDefaultValuesP2() {
        worldX =64;
        worldY =384;
        speed = 2;
        direction = null;
    }

    public void getPlayerImageP2() {
        try {
            up1_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/up1.png"));
            up2_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/up2.png"));
            up3_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/up3.png"));
            up4_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/up4.png"));
            up5_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/up5.png"));
            up6_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/up6.png"));
            up7_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/up7.png"));
            up8_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/up8.png"));
            up9_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/up9.png"));

            down1_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/down1.png"));
            down2_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/down2.png"));
            down3_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/down3.png"));
            down4_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/down4.png"));
            down5_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/down5.png"));
            down6_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/down6.png"));
            down7_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/down7.png"));
            down8_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/down8.png"));
            down9_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/down9.png"));

            left1_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/right1.png"));
            left2_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/right2.png"));
            left3_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/right3.png"));
            left4_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/right4.png"));
            left5_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/right5.png"));
            left6_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/right6.png"));
            left7_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/right7.png"));
            left8_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/right8.png"));
            left9_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/right9.png"));

            right1_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/left1.png"));
            right2_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/left2.png"));
            right3_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/left3.png"));
            right4_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/left4.png"));
            right5_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/left5.png"));
            right6_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/left6.png"));
            right7_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/left7.png"));
            right8_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/left8.png"));
            right9_p2 = ImageIO.read(getClass().getResourceAsStream("/player2/left9.png"));




        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (gp.turnManager.isPlayerTurn(this) && !moving) {
            // Player 2 must press 'R' to roll the dice if steps are 0.
            if (stepsRemaining == 0 && keyH.rPressed) {
                stepsRemaining = dice.roll();
                System.out.println("Player 2 rolled: " + stepsRemaining + " steps.");
                keyH.rPressed = false; // Reset the dice roll flag to prevent multiple rolls in one turn.
            }

            // Proceed with the movement if the dice has been rolled.
            if (stepsRemaining > 0 && (keyH.wPressed || keyH.sPressed || keyH.aPressed || keyH.dPressed)) {
                setDirectionAndTargetPositionP2();

                collisionOn = gp.cChecker.checkTileCollision(this, targetX, targetY);
                if (!collisionOn) {
                    moving = true;
                    stepsRemaining--; // Decrement steps after each move
                }

                // Reset key press states
                if (keyH.wPressed) keyH.wPressed = false;
                if (keyH.sPressed) keyH.sPressed = false;
                if (keyH.aPressed) keyH.aPressed = false;
                if (keyH.dPressed) keyH.dPressed = false;

                // End the player's turn if they have no more steps to move
                if (stepsRemaining == 0) {
                    gp.turnManager.endTurn();
                }
            }
        }

        // If in motion, continue moving towards the target
        if (moving) {
            moveTowardsTargetP2();
            updateAnimationP2();
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
                    hasKeyP2++;
                    gp.obj[i] = null;
                    System.out.println("key for P2:"+hasKeyP2);
                    break;

                case "Castle" :
                    if (hasKeyP2 >= 3){
                        gp.obj[i] = null;
                        hasKeyP2--;
                    }
                    System.out.println("key for P2:"+hasKeyP2);
                    break;

//                case "sword":
//
//                    swordP2++;
//                    gp.obj[i] = null;
//                    System.out.println("swordP2:"+swordP2);
//                    break;
            }
        }
    }
    private void setDirectionAndTargetPositionP2() {
        int tileSize = gp.tileSize;

        if (keyH.wPressed) {
            direction = "up";
            targetX = worldX;
            targetY = worldY - tileSize;
        } else if (keyH.sPressed) {
            direction = "down";
            targetX = worldX;
            targetY = worldY + tileSize;
        } else if (keyH.aPressed) {
            direction = "left";
            targetX = worldX - tileSize;
            targetY = worldY;
        } else if (keyH.dPressed) {
            direction = "right";
            targetX = worldX + tileSize;
            targetY = worldY;
        }
    }

    private void moveTowardsTargetP2() {
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
    private void updateAnimationP2() {
        spriteCounter++;
        if (spriteCounter > 7) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 3;
            } else if (spriteNum == 3) {
                spriteNum = 4;
            } else if (spriteNum == 4) {
                spriteNum = 5;
            } else if (spriteNum == 5) {
                spriteNum = 6;
            } else if (spriteNum == 6) {
                spriteNum = 7;
            } else if (spriteNum == 7) {
                spriteNum = 8;
            } else if (spriteNum == 8) {
                spriteNum = 9;
            } else if (spriteNum == 9) {
                spriteNum = 2;
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
                        image = up1_p2;
                    } else if (spriteNum == 2) {
                        image = up2_p2;
                    } else if (spriteNum == 3) {
                        image = up3_p2;
                    } else if (spriteNum == 4) {
                        image = up4_p2;
                    }else if (spriteNum == 5) {
                        image = up5_p2;
                    }else if (spriteNum == 6) {
                        image = up6_p2;
                    }else if (spriteNum == 7) {
                        image = up7_p2;
                    }else if (spriteNum == 8) {
                        image = up8_p2;
                    }else if (spriteNum == 9) {
                        image = up9_p2;
                    }

                    break;
                case "down":
                    if (spriteNum == 1) {
                        image = down2_p2;
                    } else if (spriteNum == 2) {
                        image = down2_p2;
                    } else if (spriteNum == 3) {
                        image = down3_p2;
                    } else if (spriteNum == 4) {
                        image = down4_p2;
                    }else if (spriteNum == 5){
                        image = down5_p2;
                    } else if (spriteNum == 6) {
                        image = down6_p2;
                    }else if (spriteNum == 7) {
                        image = down7_p2;
                    }else if (spriteNum == 8) {
                        image = down8_p2;
                    }else if (spriteNum == 9) {
                        image = down9_p2;
                    }


                    break;
                case "left":
                    if (spriteNum == 1) {
                        image = left1_p2;
                    } else if (spriteNum == 2) {
                        image = left2_p2;
                    } else if (spriteNum == 3) {
                        image = left3_p2;
                    } else if (spriteNum == 4) {
                        image = left4_p2;
                    }else if (spriteNum == 5) {
                        image = left5_p2;
                    } else if (spriteNum == 6) {
                        image = left6_p2;
                    }else if (spriteNum == 7) {
                        image = left7_p2;
                    }else if (spriteNum == 8) {
                        image = left8_p2;
                    }else if (spriteNum == 9) {
                        image = left9_p2;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        image = right1_p2;
                    } else if (spriteNum == 2) {
                        image = right2_p2;
                    } else if (spriteNum == 3) {
                        image = right3_p2;
                    } else if (spriteNum == 4) {
                        image = right4_p2;
                    }else if (spriteNum == 5) {
                        image = right5_p2;
                    } else if (spriteNum == 6) {
                        image = right6_p2;
                    }else if (spriteNum == 7) {
                        image = right7_p2;
                    }else if (spriteNum == 8) {
                        image = right8_p2;
                    }else if (spriteNum == 9) {
                        image = right9_p2;
                    }
                    break;
            }
        }
        if (image == null) {
            image = down1; // Default image
        }

        // Draw Player 2 image at its current position
        g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
    }
}
