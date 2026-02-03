package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Item {
    public int x;
    public int y;
    public int width = 20;
    public int height = 20;
    private final Image ITEM_IMAGE = new ImageIcon(getClass().getResource("item.png")).getImage();
    public Item(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.drawImage(ITEM_IMAGE, x, y, width, height, null);
    } 
}
