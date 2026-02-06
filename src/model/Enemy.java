package model;

import java.util.*;
/**
 * Class: Enemy
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: Represents an enemy in the game with position, size, and movement behavior.
 */

public class Enemy extends GameEntity{
    
    public Enemy(int x, int y, int width, int height, int dx, int dy) {
        super(x, y, width, height, "zombie.png", dx, dy);
    }
    
    @Override
    public void move(String[] tileMap, int tileWidth, int tileHeight) {
		int tileX = getX() / tileWidth;
		int tileY = getY() / tileHeight;
		
		if(tileX <= 0 || tileY <= 0 || tileX >= tileMap[0].length()-1 || tileY >= tileMap.length-1) {
			System.out.println("Bad Index");
			return;
		}

		ArrayList<Integer> possibleDir = new ArrayList<>();
		if(tileMap[tileY-1].charAt(tileX) != 'X') possibleDir.add(0);
		if(tileMap[tileY].charAt(tileX-1) != 'X') possibleDir.add(1);
		if(tileMap[tileY+1].charAt(tileX) != 'X') possibleDir.add(2);
		if(tileMap[tileY].charAt(tileX+1) != 'X') possibleDir.add(3);
		
		if(possibleDir.isEmpty()) return;
		
		int direction = possibleDir.get((int)(Math.random() * possibleDir.size()));
		
		switch (direction) {
			case 0:
				setY(getY()-getDY());
				break;
			case 1:
				setX(getX()-getDX());
				break;
			case 2:
				setY(getY()+getDY());
				break;
			case 3:
				setX(getX()+getDX());
				break;
		}
	}
	public void setPosition(int x, int y) {
		setX(x);
		setY(y);
	}
}
