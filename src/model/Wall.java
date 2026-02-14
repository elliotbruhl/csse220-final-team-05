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
    //Maps
    public String[] tileMap;
    
    public String[] tileMap1 = 
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
    "X............XXXXXXXX..........WW",
    "X............XXXXXXXX..........WW",
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
    
    public String[] tileMap2 = 
    {"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
    "X..............XXXXXX..............XXXXXX........X",
    "X......XXXXXX..XXXXXX..XXXXXXXXXXX..XXXXXX..XXXXXX",
    "X...........X..........X.........X..........X....X",
    "X.X.........X..........X.........X..........X....X",
    "X.X..XXXX...XXXXXXXXXXXX...XXXX..XXXXXXXXXXXX....X",
    "X.X..X..X........................X..X............X",
    "X.X..X..X.............XXXXXXXXXXXX..X..XXXXXX....X",
    "X.X..X..............XX..............X..X....X....X",
    "X.X..XXXXXXXXXX.....XX.....XXXXXXXXXX..X....X....X",
    "X.X...........X.....XX.....X...........X....X....X",
    "X.XXXXXXXXXX..X.....XX.....X..XXXX...XXXX....X...X",
    "X..........X..X.....XX.....X..X..........XXXX....X",
    "XXXXXXXXX..X..X.....XX.....X..X..XXXXXXXXXX......X",
    "X.........X..X.....XXXX.....X..X.........X.......X",
    "X..XXXXXX.X..X..............X..X.XXXXXX..X.......X",
    "X..X....X.X..XXXXXXXXXXXXXX.X..X.X....X..........X",
    "X..X....X.X................X....XXX..............X",
    "X..X....X.XXXXXXXXXXXXXXXXXX....XXX....XXX.......X",
    "X..X....X......................XXX....X..........X",
    "X..XXXXXX.....................XXXXXX..X..........X",
    "X................................................X",
    "X..XXXXXXXXXXXXXXXXXXXXX.XXXXXXXXXXXXXXXXXXXXX...X",
    "X..X.........................................X...X",
    "X..X..XXXXXXXXXXXXXXXXXXX...XXXXXXXXXXXXXXXX..X..X",
    "X..X..X.....................................X..X..",
    "X..X..X..XXXXXXXXX.XXXXXXXXXXXXXXXXXXXXXXX..X..X..",
    "X..X..X..X.................................X..X..X",
    "X..X..X..X..XXXXXXXXXXXXX..XXXXXXXXXXXXXX..X..X..X",
    "X..X..X..X..X...........................X..X..X..X",
    "X..X..X..X..X..XXXXXXXX..XXXXXXXXXXXXX..X..X..X..X",
    "X..X..X..X..X..X.....................X..X..X..X..X",
    "X..X.XXXXXX.X..X..XXXXXX..XXXXXXX..X..X..X..X..X..",
    "X..X..X..X..X..X..X.............X..X..X..X..X..X..",
    "X..X..X..X..X..X..X..XXXXXXXXX..X..X..X..X..X..X..",
    "X..X..X..X..X..X..X..X.......X..X..X..XXXXX.X..X..",
    "X..XXXXXXXX.X..X..X..X..XXX..X..X..X..X..X..X..X..",
    "X..X..X..X..X..X..X..X..X.X..X..X..X..X..X..X..X..",
    "X..X..X..XXXXXXXX.X..X..X.X..X..XXXXXXXX.X..X..X..",
    "X..X..X..X..X..X..X..X..X.X..X..X..X..X..X..X..X..",
    "X..X..X..X..X..XXXXXXX..X.X..X..X..X..X..X..X..X..",
    "X..X..X..X..X..XXXXXXX..X.X..X..X.XXXXXX.X..X..X..",
    "X..X..X..X..X..XXXXXXX..X.X..X..X.XXXXXX.X..X..X..",
    "X.................................XXXXXX.........X",
    "X.................................XXXXXX.........X",
    "X.................................XXXXXX.........X",
    "X.................................XXXXXX.........X",
    "X.................................................WW",
    "X.................................................WW",
   	"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"};
    
    public String[] tileMap3 = {
    "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
    "X....XXXX..XX....XX..........XXXX..XX....XX..XXXX....XX..XXXX....XXX",
    "X.XX.X..X.XX.XX.XX.XX.X..X.XX.X..X.XX.XX.XX.XX.X..X.XX.XX.X..X.XX..X",
    "X.X..X.XX.X..X..X..X.XX.X..X..X..X.XX.X..X..X..X.XX.X..X..XXX.X..X.X",
    "X.XX.X..X.XX.XX.XX.XX.X..X.XX.X..X.XX.XX.XX.XX.X..X.XX.XX.X..X.XX..X",
    "X....XXXX..XX....XX..XXXX....XXXX..XX....XX..XXXX....XX..XXXX....XXX",
    "X.XXXXXXXXXXXX........XXXXXX..XXXXXXXXXXXX..XXXXXXXXXXXX..XXXXXXXXXX",
    "X.X..........X..X..........X..X..........X..X..........X..X........X",
    "X.X.XXXXXXXX.X..X.XXXXXXXX.X..XXXXXXXXXX.X..X.XXXXXXXX.X..X.XXXXXX.X",
    "X.X.X......X.X..X.X......X.X..XXX......X.X..X.X......X.X..X.X....X.X",
    "X.X.X.XXXX.X.X..X.X.XXXX.X.X..XXX.XXXX.X.X..X.X.XXXX.X.X..X.X.XX.X.X",
    "X.X.X.X..X.X.X..X.X.X..X.X.X..XXX.X..X.X.X..X.X.X..X.X.X..X.X.X..X.X",
    "X.X.X.X.XX.X.X..X.X.X.XX.X.X..XXX.X.XX.X.X..X.X.X.XX.X.X..X.X.X.XX.X",
    "X.X.X.X.X..X.X..X.X.X.X..X.X..XXX.X..X.X..X.X.X.X..XXXXX..X.X.X.X..X",
    "X.X.X.X.XX.X.X..X.X.X.XX.X.X..XXX.X.XX.X.X..X.X.X.XX.X.X..X.X.X.XX.X",
    "X.X.X.X.X.......X.X.X.X..X.X..XXX.X.X..X.X..X.X.X.X..X.X..X.X.X.X..X",
    "X.X.X.X.XX......X.X.X.XX.X.X........XX.X.X..X.X.X.XX.X.X..X.X.X.XX.X",
    "X.X.X.X.X..X.X..X.X.X.X..X.X........X..X.X..X.X......X.X..X.X.X.X..X",
    "X.X.X.X.XX.X.X..X.X.X.XX.X.X..X.....XX.X.X..X.X....X.X.X..X.X.X.XX.X",
    "X.X.X.X.X..X.X..X.X.X.X..X.X..X.X.X.X..X.X..X.X......X.X..X.X.X.X..X",
    "X.X.X.X.XX.X.X..X.X.X.XX.X.X..X.X.X.XX.X.X..X.X.X.XX.X.X..X.X.X.XX.X",
    "X.X.X.X.X..X.X.........................X.X..X.X.X.X..X.X..X.X.X.X..X",
    "X.X.X.X.XX.X.X.........................X.X..X.X.X..X.X.X..X.X.X.XX.X",
    "X.X.X.X.X..X.X..X.X.X.X..X.X..X.X....................X.X..X.X.X.X..X",
    "X.X.X.X.XX.X.X..X.....XX.X.X..X.X.X.XX.............X.X.X..X.X.X.XX.X",
    "X.X.X.X.X..X.X..X.X.X.X..X.X......X.X..X.X..X.X.X....X.X..X.X.X.X..X",
    "X.X.X.X.XX.X.X..X.X.X.XX.X.X......X.XX.X.X..X.X.X.XX.X.X..X.X.X.XX.X",
    "X.X.X.X.X..X.X...........X.X......X.X..X.X..X.XXX.X..X.X..X.X.X.X..X",
   	"X.X.X.X.XX.X.X..X.X.X.XX.X.X......X.XX.X.X..X.XXXXXX.X.X..X.X.X.XX.X",
    "X.X.X.X.X..X.X..X.X.X.X..X.X......X..................X.X..X.X.X.X..X",
    "X.X.X.X.XX.X.X..X.X.X.XX.X.X..X.X.X..................X.X..X.X.X.XX.X",
    "X.X.X.X.X..X.X..X.X.X.X..XXX..X.X.X.........X.X.X.X..X.X..X.X.X.X..X",
    "X.X.X.X.XX.X.X........XX.XXX..X.X.X.........XXXXXXXX.X.X..X.X.X.XX.X",
    "X.X.X.X.X.............X..XXX..X.X.X.X..X.X..XXXXXXXX.X.X..X.X.X.X..X",
    "X.X.X.X.XX............XX.XXX..X.X.X.XX.X.X..XXXXXXXX.X.X..X.X.X.XX.X",
    "X.X.X.X.X.............X..XXX..X.X.X.X..X.X..XXXXXXXX.X.X..X.X.X.X..X",
    "X.X.X.X.XX............XX.XXX..X.X.X.XX.X.X..XXXXXXXX.X.X..X.X.X.XX.X",
    "X.X.X.X.X..X.X..X.X.X.X..XXX..X.X.X.X..X.X..XXXXXXXX.X.X..X.X.X.X..X",
    "X..................................................................X",
    "X..................................................................X",
    "X..................................................................X",
    "X..................................................................X",
    "X.........................................................WW.......X",
    "X.........................................................WW.......X",
    "X....................................................................X",
    "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
    };

    private ArrayList<GameEntity> blocks = new ArrayList<>();
    private ArrayList<GameEntity> winZones = new ArrayList<>();
    private Image BLOCK_IMG = null;

    public Wall(int level){
        try {
            BLOCK_IMG = new ImageIcon(getClass().getResource("block.png")).getImage();
        }
        catch (Exception e) {
            System.out.println("Error loading block image: " + e.getMessage());
        }
        //Select which map to use
        if (level == 1) {
        	tileMap = tileMap1;
        } else if (level == 2) {
        	tileMap = tileMap2;
        } else {
        	tileMap = tileMap3;
        }
        
        // int[][] fence = makeTileMap();
        for (int r = 0; r < tileMap.length; r++){
            for (int c = 0; c < tileMap[r].length(); c++){
            	char tile = tileMap[r].charAt(c);
            	
                if (tile == 'X'){
                    blocks.add(new Block(c * WIDTH, r * HEIGHT, WIDTH, HEIGHT));
                } else if (tile == 'W') {
                	winZones.add(new Block(c * WIDTH, r* HEIGHT, WIDTH, HEIGHT));
                }
            }
        }
//        blocks.add(new Block(500, 100, WIDTH, HEIGHT));
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
    }
}
