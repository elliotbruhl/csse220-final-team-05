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
import model.Item;
import model.GameModel;
import model.Enemy;
/**
 * Class: GameComponent
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: This class is responsible for rendering the game state and handling user input.
 */

public class GameComponent extends JComponent {
	private final Image BACKGROUND_IMG = new ImageIcon(getClass().getResource("backgroundImage.png")).getImage();
	private GameModel model;
	private Timer timer;
	public GameComponent() {
		this.model = new GameModel();
		timer = new Timer(100, e -> {
			if (!model.playerLosingGame()){
				model.updateEnemy();
				repaint();
			}
			else{
				timer.stop();
			}
			for	(Enemy enemy : model.getEnemies()){
				if (model.playerCollidesWithEnemy(enemy)){
					model.resetPlayerPosition();
					model.playerLosesOneLive();
				}
			}
			
		});
		timer.start();
	
		addKeyListener(new KeyAdapter() {
            
			@Override
			public void keyReleased(KeyEvent e){
				if (model.playerLosingGame()){
					return;
				}
				switch(e.getKeyCode()) {
					case KeyEvent.VK_W -> model.setPlayerDirection('W');
					case KeyEvent.VK_S -> model.setPlayerDirection('S');
					case KeyEvent.VK_A -> model.setPlayerDirection('A');
					case KeyEvent.VK_D -> model.setPlayerDirection('D');
				}
				
				model.updatePlayer();
		  		for (Block block : model.getBlocks()){
					if (model.playerCollidesWithWall(block)){
						model.returnPlayerToLasPos();
						break;
					}
        		}
				for (int i = model.getItems().size() - 1; i >= 0; i--) {
					Item item = model.getItems().get(i);

					if (model.playerCollidesWithItem(item)) {
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
