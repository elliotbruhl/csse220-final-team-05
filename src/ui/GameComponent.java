package ui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.Timer;


import model.Enemy;
import model.GameEntity;
import model.GameModel;
/**
 * Class: GameComponent
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: This class is responsible for rendering the game state and handling user input.
 */

public class GameComponent extends JComponent {
	private Image BACKGROUND_IMG;
	private GameModel model;
	private Timer timer;
	private int counter = 0;

	public GameComponent() {
		try {
			BACKGROUND_IMG = new ImageIcon(getClass().getResource("backgroundImage.png")).getImage();
		} catch (Exception e) {
			System.out.println("Error loading background image: " + e.getMessage());
		}
		this.model = new GameModel();
		timer = new Timer(100, e -> {
			if (!model.playerLosingGame()){
				if(counter % 4 == 0) {
					model.updateEnemy();
				}
				// if(counter % 4 == 0) model.updateEnemy();
				
				model.updateEnemy();
				repaint();
				// counter ++;
			}
			for	(GameEntity enemy : model.getEnemies()){
				if (model.handleCollision(model.getPlayer(), enemy)){
					model.resetPlayerPosition();
					model.playerLosesOneLive();
				}

				for (GameEntity block : model.getBlocks()){
					if (model.handleCollision(enemy, block)|| enemy.getX() < 0 || enemy.getY() > 550){
						// ((Enemy) enemy).cancelMovement();
						((Enemy) enemy).setDirectionRandomly();
					}
				}
			}

		});
		timer.start();

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e){
				
				if (!model.isGameStarted()) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						model.startGame();
					}
					return;
				}
				
				if (model.playerLosingGame()){
					if (e.getKeyCode() == KeyEvent.VK_R) {
						model.resetGame();
					}
					return;
				}
				
				if (model.isGameFinished()) {
					if (e.getKeyCode() == KeyEvent.VK_Q) {
						System.exit(0);
					}
					return;
				}
				
				if (model.hasPlayerWon()) {
					if (e.getKeyCode() == KeyEvent.VK_C) {
						model.nextLevel();
					} else if (e.getKeyCode() == KeyEvent.VK_Q) {
						System.exit(0);
					}
					return;
				}
				switch(e.getKeyCode()) {
					case KeyEvent.VK_W -> model.setPlayerDirection('W');
					case KeyEvent.VK_S -> model.setPlayerDirection('S');
					case KeyEvent.VK_A -> model.setPlayerDirection('A');
					case KeyEvent.VK_D -> model.setPlayerDirection('D');
				}

				model.updatePlayer();
		  		for (GameEntity block : model.getBlocks()){
					if (model.handleCollision(model.getPlayer(), block)){
						model.returnPlayerToLasPos();
						break;
					}
        		}
				for (int i = model.getItems().size() - 1; i >= 0; i--) {
					GameEntity item = model.getItems().get(i);

					if (model.handleCollision(model.getPlayer(), item)) {
						model.increasePlayerScore();
						model.getItems().remove(i);
					}
				}
				repaint();
				}
		});
		setFocusable(true);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(BACKGROUND_IMG, 0, 0, getWidth(),  getHeight() , null);
		model.draw(g2);
		
		if (!model.isGameStarted()) {
			g2.setColor(Color.WHITE);
			g2.fillRect(0, 0, getWidth(), getHeight());
			g2.setColor(Color.BLACK);
			g2.setFont(new Font("Arial", Font.BOLD, 50));
			g2.drawString("Minecraft Ripoff", 100, 200);
			g2.setFont(new Font("Arial", Font.PLAIN, 20));
			g2.drawString("Press ENTER to Start", 200, 250);
			return;
		}
		
		if (model.isGameFinished()) {
			g2.setColor(Color.GREEN);
			g2.setFont(new Font("Arial", Font.BOLD, 50));
			g2.drawString("YOU BEAT ALL LEVELS!", 80, 250);
			
			g2.setFont(new Font("Arial", Font.BOLD, 50));
			g2.drawString("Press Q to Quit", 200, 290);
		}
		
		if (model.hasPlayerWon()) {
			g2.setColor(Color.YELLOW);
			g2.setFont(new Font("Arial", Font.BOLD, 50));
			g2.drawString("LEVEL COMPLETE", 100, 250);
			
			g2.setFont(new Font("Arial", Font.PLAIN, 20));
			g2.drawString("Press C to Continue", 200, 290);
			g2.drawString("Press Q to Quit", 220, 320);
			return;
			
		}
	}
}
