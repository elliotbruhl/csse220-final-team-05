package model;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;
public class GameModel {
    private GameEntity player;
	private Wall wall;
	private GameEntity enemy1;
	private GameEntity enemy2;
    private ArrayList<GameEntity> items;
    private GameEntity[] enemies;
    public GameModel(){
        wall = new Wall();
		player = new Player(30, 20, 30, 30, 10, 10);
		enemy1 = new Enemy(180, 85, 30, 30, 10, 0);
		enemy2 = new Enemy(200, 200, 30, 30, 0, 10);
        items = new ArrayList<>();
        enemies = new Enemy[2];
        items.add(new Item(150, 200));
        items.add(new Item(400, 20));
        items.add(new Item(300, 100));  
        enemies[0] = enemy1;
        enemies[1] = enemy2;
    }

    public void updateEnemy(){
    	enemy1.move();
        enemy2.move();
    }
    
    // Method to handle player collision and logic 
    public void playerLosesOneLive(){
        ((Player) player).loseOneLive();
    }
    
    public void setPlayerDirection(char dir){
        ((Player) player).setDirection(dir);
    }

    public void updatePlayer(){
        player.move();
    }

    public void returnPlayerToLasPos(){
        ((Player) player).returnToPos();
    }

    public void resetPlayerPosition(){
        ((Player) player).resetPosition();
    }

    public boolean playerLosingGame(){
        return ((Player) player).isLosingGame();

    }

    public boolean handleCollision(GameEntity a, GameEntity b){
        return  a.getX() < b.getX() + b.getWidth() &&
                a.getX() + a.getWidth() > b.getX() &&
                a.getY() < b.getY() + b.getHeight() &&
                a.getY() + a.getHeight() > b.getY();
    }

    public void draw(Graphics2D g2){
        wall.draw(g2);
        player.draw(g2);
        enemy1.draw(g2);
        enemy2.draw(g2);
        for (GameEntity item : this.items){
            item.draw(g2);
        }

        if (this.playerLosingGame()){
            g2.setColor(Color.RED);
            g2.setFont(new Font("Arial", Font.BOLD, 50));
            g2.drawString("GAME OVER", 150, 250);
        }

    }

    public void increasePlayerScore(){
        ((Player) player).increaseScore();
    }

    public GameEntity getPlayer() { return player; }
    public ArrayList<GameEntity> getItems() { return items; }
    public ArrayList<Block> getBlocks() {return wall.blocks;}
    public GameEntity[] getEnemies() {return enemies;}
}