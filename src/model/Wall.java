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
    public final int[][] tileMap;
    public ArrayList<Block> blocks = new ArrayList<>();
    private final Image BLOCK_IMG = new ImageIcon(getClass().getResource("block.png")).getImage();

    public Wall(){
        tileMap = makeTileMap();
        for (int r = 0; r < tileMap.length; r++){
            for (int c = 0; c < tileMap[r].length; c++){
                if (tileMap[r][c] == 1){
                    blocks.add(new Block(c * WIDTH, r * HEIGHT, WIDTH, HEIGHT));
                }
            }
        }
    }  

    public void drawOn(Graphics2D g2){
        for (int i = 0; i < blocks.size(); i++){
            g2.drawImage(BLOCK_IMG, blocks.get(i).x, blocks.get(i).y, blocks.get(i).width, blocks.get(i).height, null);
        }
    }

    int[][] makeTileMap() {
        int[][] map = new int[30][30];
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                if (r == 0 || r == map.length - 1 || c == 0 || c == map[r].length - 1) map[r][c] = 1;
            }
        }
        return map;
    }
}
