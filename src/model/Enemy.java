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



    public boolean willCollideX(GameEntity b) {
        int nextX = getX() + getDX();
        return nextX < b.getX() + b.getWidth() &&
            nextX + getWidth() > b.getX() &&
            getY() < b.getY() + b.getHeight() &&
            getY() + getHeight() > b.getY();
    }

    public boolean willCollideY(GameEntity b) {
        int nextY = getY() + getDY();
        return getX() < b.getX() + b.getWidth() &&
            getX() + getWidth() > b.getX() &&
            nextY < b.getY() + b.getHeight() &&
            nextY + getHeight() > b.getY();
    }
    public void cancelMoveOnX(){
        setX(getX()- getDX());
    }

    public void cancelMoveOnY(){
        setX(getY()- getDY());
    }


    public void flipX(){
        setDX(-getDX());
    }

    public void flipY(){
        setDY(-getDY());
    }

}