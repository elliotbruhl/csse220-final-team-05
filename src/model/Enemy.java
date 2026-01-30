package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy {
    private int x; 
    private int y;
    private int width; 
    private int height;
    private int Vx = 10;
    private int Vy = 10;
    private Image enemyImage;
    public Enemy(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
        this.width = width;
        this.height = height;
        enemyImage = new ImageIcon(getClass().getResource("zombie.png")).getImage();
	}
	public void draw(Graphics2D g2) {
		g2.setColor(Color.RED);
        g2.drawImage(enemyImage, x, y, width, height, null);

    }
    public void moveX(){
        x += Vx;
        if (x >= 570 || x <= 0){
            Vx = -Vx;
        }    
    }

    public void moveY(){
        y += Vy;
        if (y >= 580 || y <= 0){
            Vy = -Vy;
        }
    }
}
