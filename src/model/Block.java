package model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Class: Block
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: Represents a block in the game with position and size attributes.
 */

public class Block {
    public int x;
    public int y;
    public int width;
    public int height;
    public final Image shape = new ImageIcon(getClass().getResource("block.png")).getImage();

    public Block(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}