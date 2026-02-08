package model;

import java.util.*;
/**
 * Class: Enemy
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: Represents an enemy in the game with position, size, and movement behavior.
 */

public class Enemy extends GameEntity{
    private char direction = 'U';
	private char[] directions = {'U', 'D', 'R', 'L'};


    public Enemy(int x, int y, int width, int height, int dx, int dy) {
        super(x, y, width, height, "zombie.png", dx, dy);
    }
    
	public void move(){
		setX(getX() + getDX());
		setY(getY() + getDY());
	}

	public void updateVelocity(){
		     if (this.direction == 'U') {
                setDx(0);
        		setDy(-10);            
			}
            else if (this.direction == 'D') {
                setDx(0); 
                setDy(10);
            }
            else if (this.direction == 'L') {
                setDx(-10);
                setDy(0);
            }
            else if (this.direction == 'R') {
                setDx(10); 
                setDy(0);
            }
	}

	// @Override
	// public void updateDirection(char previousDirection) {
		
	// }

	public void cancelMovement(){
		setDx(0);
		setDy(0);
	}

	public void setDirectionRandomly(){
		Random random = new Random();
		this.direction = directions[random.nextInt(4)];
	}

	public char getDirection(){
		return this.direction;
	}

	public void setPosition(int x, int y) {
		setX(x);
		setY(y);
	}
}