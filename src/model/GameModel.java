package model;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.Timer;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;
public class GameModel {
    private Player player;
	private Wall wall;
	private Enemy enemy1;
	private Enemy enemy2;
    public ArrayList<Item> items;
    public Enemy[] enemies;
    public GameModel(){
        wall = new Wall();
		player = new Player();
		enemy1 = new Enemy(100, 100, 30, 30);
		enemy2 = new Enemy(200, 200, 30, 30);
        items = new ArrayList<>();
        enemies = new Enemy[2];
        items.add(new Item(70, 200));
        items.add(new Item(400, 20));
        items.add(new Item(200, 100));  
        enemies[0] = enemy1;
        enemies[1] = enemy2;
    }

    public void updateEnemy(){
    	enemy1.moveX();
        enemy2.moveY();
    }
        
    
    public void setPlayerDirection(char dir){
        player.setDirection(dir);
    }

    public void updatePlayer(){
        // player.move(wall.tileMap, wall.WIDTH, wall.HEIGHT);
        player.move();

    }

    public void returnPlayerToLasPos(){
        player.returnToPos();
    }

    public void resetPlayerPosition(){
        player.resetPosition();
    }

    public boolean playerLosingGame(){
        return player.isLosingGame();
    }
    public boolean playerCollidesWithWall(Block block) {
        int newX = player.getX();
        int newY = player.getY();

        return newX < block.x + block.width &&
            newX + player.WIDTH > block.x &&
            newY < block.y + block.height && 
            newY + player.HEIGHT > block.y;
    }

    public boolean playerCollidesWithItem(Item item) {
        int newX = player.getX();
        int newY = player.getY();

        return newX < item.x + item.width &&
            newX + player.WIDTH > item.x &&
            newY < item.y + item.height && 
            newY + player.HEIGHT > item.y;
    }

    public boolean playerCollidesWithEnemy(Enemy enemy) {
        int newX = player.getX();
        int newY = player.getY();

        return newX < enemy.x + enemy.WIDTH &&
            newX + player.WIDTH > enemy.x &&
            newY < enemy.y + enemy.HEIGHT && 
            newY + player.HEIGHT > enemy.y;
    }

    public void draw(Graphics2D g2){
        wall.draw(g2);
        player.draw(g2);
        enemy1.draw(g2);
        enemy2.draw(g2);
        for (Item item : this.items){
            item.draw(g2);
        }

        if (player.isLosingGame()){
            g2.setColor(Color.RED);
            g2.setFont(new Font("Arial", Font.BOLD, 50));
            g2.drawString("GAME OVER", 180, 300);
        }

    }

    // Getter methods
    public Enemy getEnemy1() { return enemy1; }
    public Enemy getEnemy2() { return enemy2; }
    public ArrayList<Item> getItems() { return items; }

    public Player getPlayer() { return player; }
    public Wall getWall() { return wall; }
    public ArrayList<Block> getBlocks() {return wall.blocks;}
    public Enemy[] getEnemies() {return enemies;}


}