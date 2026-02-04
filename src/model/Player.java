package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Font;

/**
 * Class: Player
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: Represents the player in the game with position, size, and movement behavior.
 */

public class Player {
    private int x = 30;
    private int y = 20;
    private final int DX = 10; 
    private final int DY = 10;
    public final int WIDTH = 30;
    public final int HEIGHT = 30;
    private char direction; // 'W/A/S/D' for up/left/down/right
    private int score;
    private int lives = 3;
    private final Image PLAYER_IMAGE = new ImageIcon(getClass().getResource("player.png")).getImage();;
    private final Image HEART = new ImageIcon(getClass().getResource("heart.png")).getImage();;

    public void draw(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.drawImage(PLAYER_IMAGE, x, y, WIDTH, HEIGHT, null);
        g2.setFont(new Font("Serif", Font.BOLD, 20));
        g2.drawString("Score: " + String.valueOf(this.score), 0, 17);
        g2.drawString("Lives: ", 85, 17);

        int xCor = 150;
        for (int i = 0; i < this.lives; i++){
            g2.drawImage(HEART, xCor, 0, 20, 20, null);
            xCor += 35;
        }

    } 
    public void loseOneLive(){
        this.lives -= 1;
    }
    public void increaseScore(){
        this.score += 1;
    }

    public boolean isLosingGame(){
        return this.lives == 0;
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

    public void resetPosition(){
        this.x = 30;
        this.y = 20;
    }
    public void move(/*int[][] tileMap, int tileWidth, int tileHeight*/){
        // int playerTileX = x / tileWidth;
        // int playerTileY = y / tileHeight;

        if (direction == 'W' && this.y < 0) {
            return; // Blocked moving up
        }
        if (direction == 'S' && this.y > 610) {
            return; // Blocked moving down
        }
        if (direction == 'A' && this.x < 0) {
            return; // Blocked moving left
        }
        if (direction == 'D' && this.x > 590) {
            return; // Blocked moving right
        }
        
        switch (this.direction) {
            case 'W' -> y -= DY;
            case 'S' -> y += DY;
            case 'A' -> x -= DX;
            case 'D' -> x += DX;
        }
    }

    public void returnToPos(){
         switch (this.direction) {
            case 'W' -> y += DY;
            case 'S' -> y -= DY;
            case 'A' -> x += DX;
            case 'D' -> x -= DX;
        }
    }
}