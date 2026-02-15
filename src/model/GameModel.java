package model;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.Font;
import java.awt.Color;

public class GameModel {
    private boolean gameStarted = false;
	public boolean isGameStarted() {return gameStarted;}
    private GameEntity player;
	private Wall wall;
    private ArrayList<GameEntity> items;
    private ArrayList<GameEntity> enemies;
    private ArrayList<GameEntity> blocks;
    private ArrayList<GameEntity> winzones;
    private int maxLevel = 3;
    private static int currentLevel;
    public int getCurrentLevel() {return currentLevel;}
    private final int TILE_SIZE = 30;
    private int startX;
    private int startY;
    public GameModel(){
        currentLevel ++;
        blocks = new ArrayList<>();
        enemies = new ArrayList<>();
        items = new ArrayList<>();
        winzones = new ArrayList<>();
        loadLevel();
        player = new Player(startX, startY, TILE_SIZE, 10, 10);
        wall = new Wall(blocks, winzones);
    }
    public void updateEnemy(){
    	for (GameEntity enemy : enemies){
            enemy.move();
        }
    }
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
        ((Player) player).resetPosition(startX, startY);
    }

    public boolean playerLosingGame(){
        return ((Player) player).isLosingGame();

    }
    public void loadLevel() {
	    File file = new File("level" + currentLevel + ".txt");
        int x = 0;
        int y = 0;
	    try {
		    int row = 0;
	    	Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				 for (int col = 0; col < line.length(); col++) {
					    char c = line.charAt(col);

					    if (c == 'P' || c == 'E' || c == 'I'|| c == 'X'|| c== 'W') {
					    	 x = col * TILE_SIZE;
					    	 y = row * TILE_SIZE;	      
					    }
					    
                        if (c == 'W'){
                            winzones.add(new Block(x, y, TILE_SIZE, TILE_SIZE));
                        }

                        if (c == 'X'){
                            blocks.add(new Block(x, y, TILE_SIZE, TILE_SIZE));
                        }

					    if (c == 'P') {
					        startX = x;
					        startY = y;
					    } 
                        else if (c == 'E') {
					        enemies.add(new Enemy(x, y, TILE_SIZE, 10, 10));
					    }

                        else if (c == 'I'){
                            items.add(new Item(x, y));
                        }
				 }

				 row++;
			}
			scanner.close();
        }
            catch (FileNotFoundException e1) {
			System.out.println("level" + currentLevel + ".txt not found");
		}
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
        for (GameEntity enemy : enemies){
            enemy.draw(g2);
        }
        for (GameEntity item : this.items){
            item.draw(g2);
        }
        if (this.playerLosingGame()){
            g2.setColor(Color.RED);
            g2.setFont(new Font("Arial", Font.BOLD, 50));
            g2.drawString("GAME OVER", 150, 250);
            g2.setFont(new Font("Arial", Font.BOLD, 25));
            g2.drawString("Do you want to do it agian?", 150, 290);
        }
        if (this.playerFinishGame()){
            wall.drawDoor(g2);
            g2.setColor(Color.YELLOW);
            g2.setFont(new Font("Arial", Font.BOLD, 40));
            g2.drawString("YOU'VE FINISHED THE GAME", 20, 250);
            g2.setFont(new Font("Arial", Font.BOLD, 25));
            g2.drawString("Do you want to do it agian?", 150, 290);
        }

        else if (this.playerWinGame()){
            wall.drawDoor(g2);
            g2.setColor(Color.YELLOW);
			g2.setFont(new Font("Arial", Font.BOLD, 50));
			g2.drawString("LEVEL COMPLETE", 90, 300);
			g2.setFont(new Font("Arial", Font.PLAIN, 20));
        } 
    }

       
    public void startGame() {
    	gameStarted = true;
    }
    public boolean playerWinGame(){
        return playerInWinZone() && items.isEmpty();
    }
    public void increasePlayerScore(){
        ((Player) player).increaseScore();
    }

    public boolean playerInWinZone() {
    	for (GameEntity zone : wall.getWinZones()) {
    		if (handleCollision(player, zone)) {
    			return true;
    		}
    	}
    	return false;
    }
    public void clearCurrentEntity(){
        blocks.clear();
        winzones.clear();
        enemies.clear();
    }

    public boolean playerFinishGame(){
        return currentLevel == maxLevel && playerInWinZone() && items.isEmpty();
    }

    public void resetLevel(){
        currentLevel = 0;
    }

    public void nextLevel(){
        currentLevel++;
    }

    public void clearGameEntity(){
        items.clear();
        enemies.clear();
        blocks.clear();
        winzones.clear();
    }
    public GameEntity getPlayer() { return player; }
    public ArrayList<GameEntity> getItems() { return items; }
    public ArrayList<GameEntity> getBlocks() {return wall.getWallBlocks();}
    public ArrayList<GameEntity> getEnemies() {return enemies;}
}