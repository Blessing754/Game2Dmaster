package main;

import PlayerEntity.PlayerEntity;

import java.awt.*;

public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp){
        this.gp=gp;

    }

    public boolean checkTile(PlayerEntity entity, String direction) {
        int nextX = entity.worldX;
        int nextY = entity.worldY;

        if (direction.equals("up")) {
            nextY = entity.worldY - entity.speed;
        } else if (direction.equals("down")) {
            nextY = entity.worldY + entity.speed;
        } else if (direction.equals("left")) {
            nextX = entity.worldX - entity.speed;
        } else if (direction.equals("right")) {
            nextX = entity.worldX + entity.speed;
        }

        // Convert nextX and nextY to tile positions
        int tileX = nextX / gp.tileSize;
        int tileY = nextY / gp.tileSize;

        // Check if the tile at the new position is solid
        if (gp.tileM.tile[gp.tileM.mapTileNum[tileX][tileY]].collision) {
            return true;
        }

        return false;
    }
    public boolean checkTileCollision(PlayerEntity entity, int targetX, int targetY) {
        // Calculate the future position's tile coordinates
        int tileX = targetX / gp.tileSize;
        int tileY = targetY / gp.tileSize;

        // Check if the tile at the future position is solid
        if (gp.tileM.tile[gp.tileM.mapTileNum[tileX][tileY]].collision) {
            return true; // Collision detected
        }

        return false; // No collision
    }
    // In the CollisionChecker class
    public int checkObject(PlayerEntity entity, boolean player) {
        int index = 999;

        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                // Get entity's solid area position
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                // Get the object's solid area position
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                // Check for collision based on the direction
                if (entity.direction != null) {
                    switch (entity.direction) {
                        case "up":
                            entity.solidArea.y -= entity.speed;
                            if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                                if (gp.obj[i].collision == true) {
                                    entity.collisionOn = true;
                                }
                                if (player == true) {
                                    index = i;
                                }
                            }
                            break;
                        case "down":
                            entity.solidArea.y += entity.speed;
                            if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                                if (gp.obj[i].collision == true) {
                                    entity.collisionOn = true;
                                }
                                if (player == true) {
                                    index = i;
                                }
                            }
                            break;
                        case "left":
                            entity.solidArea.x -= entity.speed;
                            if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                                if (gp.obj[i].collision == true) {
                                    entity.collisionOn = true;
                                }
                                if (player == true) {
                                    index = i;
                                }
                            }
                            break;
                        case "right":
                            entity.solidArea.x += entity.speed;
                            if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                                if (gp.obj[i].collision == true) {
                                    entity.collisionOn = true;
                                }
                                if (player == true) {
                                    index = i;
                                }
                            }
                            break;
                    }
                }else {
                   // System.err.println("Warning: Entity direction is null.");
                }

                // Reset solid area positions after checking
                entity.solidArea.x = entity.solidAreaDX;
                entity.solidArea.y = entity.solidAreaDY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDY;
            }
        }
        return index;
    }


}
