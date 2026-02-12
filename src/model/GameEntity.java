package model;

import javax.swing.ImageIcon;
import java.awt.Graphics2D;
import java.awt.Image;

public abstract class GameEntity {
    private int x; 
    private int y;
    private int dx;
    private int dy;
    private int WIDTH; 
    private int HEIGHT;
    private String imageSource;
    private Image EntityImg;

    public GameEntity(int x, int y, int WIDTH, int HEIGHT, String imageSource, int dx, int dy){
        this.x = x;
        this.y = y;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.imageSource = imageSource;
        this.dx = dx;
        this.dy = dy;
        EntityImg = new ImageIcon(getClass().getResource(this.imageSource)).getImage();
    }

    public Image getImage(){
        return EntityImg;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
    public int getWidth(){
        return this.WIDTH;
    }

    public int getHeight(){
        return this.HEIGHT;
    }

    public int getDX(){
        return this.dx;
    }

    public int getDY(){
        return this.dy;
    }

    public void setDX(int newDx){
        this.dx = newDx;
    }

    public void setDY(int newDy){
        this.dy = newDy;
    }


    public void setX(int newX){
        this.x = newX;
    }

    public void setY(int newY){
        this.y = newY;
    }
    public void move(){
        x += dx;
        y += dy;
        // if (x <= 160 || x >= 430){
        //     dx = -dx;
        // }    
        // if (y >= 490 || y <= 0){
        //     dy = -dy;
        // }
    }
    public void draw(Graphics2D g2){
        g2.drawImage(EntityImg, x, y, WIDTH, HEIGHT, null);
    }

}
