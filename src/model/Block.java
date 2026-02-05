package model;
/**
 * Class: Block
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: Represents a block in the game with position and size attributes.
 */

public class Block extends GameEntity{

    public Block(int x, int y, int width, int height){
        super(x, y, width, height, "block.png", 0, 0);
    }
}