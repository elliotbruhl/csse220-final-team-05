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
    private ArrayList<GameEntity> blocks;
    private ArrayList<GameEntity> winZones;

    private final Image BLOCK_IMG = new ImageIcon(getClass().getResource("block.png")).getImage();
    private final Image DOOR_IMG = new ImageIcon(getClass().getResource("door.png")).getImage();
    private final Image OPENING_DOOR = new ImageIcon(getClass().getResource("doorOpened.png")).getImage();

    public Wall(ArrayList<GameEntity> blocksMap, ArrayList<GameEntity> winzones){
        blocks = blocksMap;
        winZones = winzones;
    }  
    
    public ArrayList<GameEntity> getWallBlocks(){
    	return blocks;
    }

    public ArrayList<GameEntity> getWinZones() {
    	return winZones;
    }
    
    public void draw(Graphics2D g2){
        for (int i = 0; i < blocks.size(); i++){
            g2.drawImage(BLOCK_IMG, blocks.get(i).getX(), blocks.get(i).getY(), 
                        blocks.get(i).getWidth(), blocks.get(i).getHeight(), null);
        }
        g2.drawImage(DOOR_IMG, winZones.get(0).getX(), winZones.get(0).getY(), 
                        winZones.get(0).getWidth(), winZones.get(0).getHeight(), null);
    }

    public void drawDoor(Graphics2D g2){
        g2.drawImage(OPENING_DOOR, winZones.get(0).getX(), winZones.get(0).getY(), 
                        winZones.get(0).getWidth(), winZones.get(0).getHeight(), null);
    }
}
