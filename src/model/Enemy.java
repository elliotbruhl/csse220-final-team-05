package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Class: Enemy
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: Represents an enemy in the game with position, size, and movement behavior.
 */

public class Enemy {
    private int x; 
    private int y;
    private final int WIDTH; 
    private final int HEIGHT;
    private int dx = 10;
    private int dy = 10;
    private final Image ENEMY_IMAGE;

    public Enemy(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
        this.WIDTH = width;
        this.HEIGHT = height;
        ENEMY_IMAGE = new ImageIcon(getClass().getResource("zombie.png")).getImage();
	}
    
	public void draw(Graphics2D g2) {
		g2.setColor(Color.RED);
        g2.drawImage(ENEMY_IMAGE, x, y, WIDTH, HEIGHT, null);
    }

    public void moveX(){
        x += dx;
        if (x >= 570 || x <= 0){
            dx = -dx;
        }    
    }

    public void moveY(){
        y += dy;
        if (y >= 580 || y <= 0){
            dy = -dy;
        }
    }
}
