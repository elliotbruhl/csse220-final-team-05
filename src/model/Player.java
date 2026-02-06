package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Class: Player
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: Represents the player in the game with position, size, and movement behavior.
 */

public class Player extends GameEntity{
    private char direction; // 'W/A/S/D' for up/left/down/right
    private int score;
    private int lives = 3;
    private final Image PLAYER_IMAGE = new ImageIcon(getClass().getResource("player.png")).getImage();
    private Image HEART;
    
    public Player(int x, int y, int WIDTH, int HEIGHT, int dx, int dy) {
        super(x, y, WIDTH, HEIGHT, "player.png", dx, dy);
        try {
            HEART = new ImageIcon(getClass().getResource("heart.png")).getImage();
        }
        catch (Exception e) {
            System.out.println("Error loading heart image: " + e.getMessage());
        }
    }
    

    @Override
    public void draw(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.drawImage(this.PLAYER_IMAGE, super.getX(), super.getY(), super.getWidth(), super.getHeight(), null);
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

    // public int getX(){
    //     return x;
    // }

    // public int getY(){
    //     return y;
    // }

    //  public int getDX(){
    //     return DX;
    // } 

    // public int getDY(){
    //     return DY;
    // }

    public void setDirection(char direction){
        this.direction = direction;
    }
    
    public void resetPosition(){
        super.setX(30); 
        super.setY(20);
    }
    
    public void movePlayer(){
        // int playerTileX = x / tileWidth;
        // int playerTileY = y / tileHeight;

        if (direction == 'W' && super.getY() < 0) {
            return; // Blocked moving up
        }
        if (direction == 'S' && super.getY() > 610) {
            return; // Blocked moving down
        }
        if (direction == 'A' && super.getX() < 0) {
            return; // Blocked moving left
        }
        if (direction == 'D' && super.getX() > 590) {
            return; // Blocked moving right
        }
        
        switch (this.direction) {
            case 'W' -> super.setY(super.getY() - super.getDY());
            case 'S' -> super.setY(super.getY() + super.getDY());
            case 'A' ->super.setX(super.getX() - super.getDX());
            case 'D' ->super.setX(super.getX() + super.getDX());
        }
    }

    public void returnToPos(){
         switch (this.direction) {
            case 'W' -> super.setY(super.getY() + super.getDY());
            case 'S' -> super.setY(super.getY() - super.getDY());
            case 'A' ->super.setX(super.getX() + super.getDX());
            case 'D' ->super.setX(super.getX() - super.getDX());
        }
    }
}