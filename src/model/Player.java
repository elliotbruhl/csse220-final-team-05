package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Class: Player
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: Represents the player in the game with position, size, and movement behavior.
 */

public class Player {
    private int x = 50;
    private int y = 50;
    private final int DX = 10; 
    private final int DY = 10;
    private final int WIDTH = 30;
    private final int HEIGHT = 30;
    private char direction; // 'W/A/S/D' for up/left/down/right
    private final Image PLAYER_IMAGE = new ImageIcon(getClass().getResource("player.png")).getImage();;
    
    public void drawOn(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.drawImage(PLAYER_IMAGE, x, y, WIDTH, HEIGHT, null);
    } 

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

     public int getDX(){
        return DX;
    } 

    public int getDY(){
        return DY;
    }

    public void setDirection(char direction){
        this.direction = direction;
    }

    public void move(int[][] tileMap, int tileWidth, int tileHeight){
        int playerTileX = x / tileWidth;
        int playerTileY = y / tileHeight;

        if (direction == 'W' && playerTileY > 0 && tileMap[playerTileY - 1][playerTileX] == 1) {
            return; // Blocked moving up
        }
        if (direction == 'S' && playerTileY < tileMap.length - 1 && tileMap[playerTileY + 1][playerTileX] == 1) {
            return; // Blocked moving down
        }
        if (direction == 'A' && playerTileX > 0 && tileMap[playerTileY][playerTileX - 1] == 1) {
            return; // Blocked moving left
        }
        if (direction == 'D' && playerTileX < tileMap[0].length - 1 && tileMap[playerTileY][playerTileX + 1] == 1) {
            return; // Blocked moving right
        }
        
        switch (this.direction) {
            case 'W' -> y -= DY;
            case 'S' -> y += DY;
            case 'A' -> x -= DX;
            case 'D' -> x += DX;
        }
    }
}