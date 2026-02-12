package model;
/**
 * Class: Enemy
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: Represents an enemy in the game with position, size, and movement behavior.
 */

public class Enemy extends GameEntity{
    public Enemy(int x, int y, int width, int height, int dx, int dy) {
        super(x, y, width, height, "zombie.png", dx, dy);
    }
}
