package model;
import java.awt.Graphics2D;
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
		enemy1 = new Enemy(180, 85, 30, 30);
		enemy2 = new Enemy(200, 200, 30, 30);
        items = new ArrayList<>();
        enemies = new Enemy[2];
        items.add(new Item(150, 200));
        items.add(new Item(400, 20));
        items.add(new Item(300, 100));  
        enemies[0] = enemy1;
        enemies[1] = enemy2;
    }

    public void updateEnemy(){
    	enemy1.moveX();
        enemy2.moveY();
    }
    
    // Method to handle player collision and logic 
    public void playerLosesOneLive(){
        player.loseOneLive();
    }
    
    public void setPlayerDirection(char dir){
        player.setDirection(dir);
    }

    public void updatePlayer(){
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
        return player.getX() < block.x + block.width &&
            player.getX() + player.WIDTH > block.x &&
            player.getY() < block.y + block.height && 
            player.getY() + player.HEIGHT > block.y;
    }

    public boolean playerCollidesWithItem(Item item) {
        return player.getX() < item.x + item.width &&
            player.getX() + player.WIDTH > item.x &&
            player.getY() < item.y + item.height && 
            player.getY() + player.HEIGHT > item.y;
    }

    public boolean playerCollidesWithEnemy(Enemy enemy) {
        return player.getX() < enemy.x + enemy.WIDTH &&
            player.getX() + player.WIDTH > enemy.x &&
            player.getY() < enemy.y + enemy.HEIGHT && 
            player.getY() + player.HEIGHT > enemy.y;
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
            g2.drawString("GAME OVER", 150, 250);
        }

    }

    public void increasePlayerScore(){
        player.increaseScore();
    }


    // Getter methods
    // public Enemy getEnemy1() { return enemy1; }
    // public Enemy getEnemy2() { return enemy2; }

    // public Player getPlayer() { return player; }
    // public Wall getWall() { return wall; }
    public ArrayList<Item> getItems() { return items; }
    public ArrayList<Block> getBlocks() {return wall.blocks;}
    public Enemy[] getEnemies() {return enemies;}


}