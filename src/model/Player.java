package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.lang.classfile.instruction.SwitchCase;

import javax.swing.ImageIcon;

public class Player {
    private int x = 50;
    private int y = 50;
    private  int dx = 10; 
    private  int dy = 10;
    private int width = 30;
    private int height = 30;
    private char direction; // 'U/D/L/R' 
    private Image playerImage = new ImageIcon(getClass().getResource("player.png")).getImage();;
    
    public void drawOn(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.drawImage(playerImage, x, y, width, height, null);
    } 

    public int getX(){
        return x;
    } 

    public int getY(){
        return y;
    }

     public int getdX(){
        return x;
    } 

    public int getdY(){
        return y;
    }
    public void setDirection(char direction){
        this.direction = direction;
    }
    public void move(){
            switch (this.direction) {
                case 'W':
                    y -= dy;
                    break;
                case 'S':
                    y += dy;
                    break;
                case 'A':
                    x -= dx;
                    break;
                case 'D':
                    x += dx;
                    break;
                default:
                    break;
            }        
    }

    


}
