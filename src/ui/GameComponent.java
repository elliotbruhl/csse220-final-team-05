package ui;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.Timer;
import model.Block;
import model.GameModel;
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
				if(counter % 4 == 0) model.updateEnemy();
				repaint();
				counter ++;
			}
			for	(GameEntity enemy : model.getEnemies()){
				if (model.handleCollision(model.getPlayer(), enemy)){
					model.resetPlayerPosition();
					model.playerLosesOneLive();
				}
				// for (GameEntity block : model.getBlocks()){
				// 	if (model.handleCollision(enemy, block)){
				// 		model.updateEnemyDirection();
				// 	}
				// }  
			}
			
		});
		timer.start();
	
		addKeyListener(new KeyAdapter() {
            
			@Override
			public void keyReleased(KeyEvent e){
				if (model.playerLosingGame()){
					if (e.getKeyCode() == KeyEvent.VK_R) {
						model.resetGame();
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
						model.returnPlayerToLastPos();
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
	}
}
