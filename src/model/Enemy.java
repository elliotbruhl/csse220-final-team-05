package model;
/**
 * Class: Enemy
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: Represents an enemy in the game with position, size, and movement behavior.
 */

public class Enemy extends GameEntity{
    char[] directions = {'U', 'D', 'L', 'R'};
    public Enemy(int x, int y, int width, int height, int dx, int dy) {
        super(x, y, width, height, "zombie.png", dx, dy);
    }

    public void moveRandomly(int randomNum){
        switch (directions[randomNum]) {
            case 'U' ->super.setDx(Math.abs(super.getDY()));
            case 'D' ->super.setY(-Math.abs(super.getDX()));
            case 'R' ->super.setX(-Math.abs(super.getDY()));
            case 'L' ->super.setX(Math.abs(super.getDX()));
        }
    }
    
}
