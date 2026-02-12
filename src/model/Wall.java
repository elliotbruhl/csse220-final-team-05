package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Class: Wall
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: Represents the walls in the game using a tile map.
 */

public class Wall {
    public final int WIDTH = 20;
    public final int HEIGHT = 20;
    public final String[] tileMap = 
    {"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
    "X............XXXX............X",
    "X............XXXX............X",
    "X....XXXX........XXXX.....XXXX.",
    "X....XXXX.................XXXX.",
    "X....XXXX.................XXXX.",
    "X....XXXX........XXXX.....XXXX.",
    "X............XXXX............X",
    "X............XXXX............X",
    "XXXXXXX................XXXXXXX",
    "XXXXXXX................XXXXXXX",
    "XXXXXXX.....XXXXXXXX.....XXXXXX",
    "X............XXXXXXXX............",
    "X............XXXXXXXX............",
    "XXXXXXX.....XXXXXXXX.....XXXXXXX",
    "XXXXXXX................XXXXXXX",
    "XXXXXXX................XXXXXXX",
    "X............XXXX............X",
    "X............XXXX............X",
    "X....XXXX.....XXXX.....XXXXXXX.",
    "X....XXXX..............XXXXXXX.",
    "X....XXXX..............XXXXXXX.",
    "X....XXXX.....XXXX.....XXXXXXX.",
    "X............XXXX............X",
    "X............XXXX............X",
    "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
    "..............................",
    "..............................",
    "..............................",
    ".............................."};

    private ArrayList<GameEntity> blocks = new ArrayList<>();
    private final Image BLOCK_IMG = new ImageIcon(getClass().getResource("block.png")).getImage();

    public Wall(){
        // int[][] fence = makeTileMap();
        for (int r = 0; r < tileMap.length; r++){
            for (int c = 0; c < tileMap[r].length(); c++){
                if (tileMap[r].charAt(c) == 'X'){
                    blocks.add(new Block(c * WIDTH, r * HEIGHT, WIDTH, HEIGHT));
                }
            }
        }
        blocks.add(new Block(500, 100, WIDTH, HEIGHT));
    }  
    
    public ArrayList<GameEntity> getWallBlocks(){
    	return blocks;
    }
    
    public void draw(Graphics2D g2){
        for (int i = 0; i < blocks.size(); i++){
            g2.drawImage(BLOCK_IMG, blocks.get(i).getX(), blocks.get(i).getY(), 
                        blocks.get(i).getWidth(), blocks.get(i).getHeight(), null);
        }
    }
}
