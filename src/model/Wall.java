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
    static int width = 20;
    static int height = 20;
    String[] tileMap = {
        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
        "X                            X",
        "X     XXXXX          XXXXX   X",
        "X     X   X          X   X   X",
        "X     X   X          X   X   X",
        "X     XXXXX          XXXXX   X",
        "X                            X",
        "X        XXXXX               X",
        "X        X   X               X",
        "X        X   X               X",
        "X        XXXXX               X",
        "X                            X",
        "X   XXXXX          XXXXX      X",
        "X   X   X          X   X      X",
        "X   X   X          X   X      X",
        "X   XXXXX          XXXXX      X",
        "X                            X",
        "X               XXXXX        X",
        "X               X   X        X",
        "X               X   X        X",
        "X               XXXXX        X",
        "X                            X",
        "X      XXXXX                 X",
        "X      X   X                 X",
        "X      X   X                 X",
        "X      XXXXX                 X",
        "X                            X",
        "X                            X",
        "X                            X",
        "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
    };
    public static ArrayList<Block> blocks = new ArrayList<>();
    Image block = new ImageIcon(getClass().getResource("block.png")).getImage();

    public Wall(){
        for (int r = 0; r < tileMap.length; r++){
                for (int c = 0; c < tileMap[r].length(); c++){
                    if (tileMap[r].charAt(c) == 'X'){
                        blocks.add(new Block(c * width, r * height, width, height));
                    }
                }
            }
    }  

    public void drawOn(Graphics2D g2){
        for (int i = 0; i < blocks.size(); i++){
            g2.drawImage(blocks.get(i).shape, blocks.get(i).x, blocks.get(i).y, blocks.get(i).width, blocks.get(i).height, null);
        }
    }
}
