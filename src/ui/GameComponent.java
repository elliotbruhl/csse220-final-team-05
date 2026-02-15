package ui;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.*;
import model.Enemy;
import model.GameModel;
import model.GameEntity;
/**
 * Class: GameComponent
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: This class is responsible for rendering the game state and handling user input.
 */

public class GameComponent extends JComponent {
	private Image BACKGROUND_IMG;
	private Image THEME_IMG;
	private GameModel model;
	private Timer timer;
	private JButton continueButton;
	private JButton quitButton;
	private JButton yesButton;
	private JButton noButton;

	public GameComponent() {
		this.model = new GameModel();
		continueButton = new JButton("Continue");
		quitButton = new JButton("Quit");
		yesButton = new JButton("Yes");
		noButton = new JButton("No");
		yesButton.setBounds(210, 320, 70, 40);
		noButton.setBounds(290, 320, 70, 40);
		continueButton.setBounds(190, 320, 100, 40);
		quitButton.setBounds(310, 320, 100, 40);

		yesButton.addActionListener(e -> {
			model.resetLevel();
			this.model = new GameModel();
			model.startGame();
			timer.start();

		});

		noButton.addActionListener(e -> {
			System.exit(0);
		});
		continueButton.addActionListener(e -> {
			model.clearGameEntity();
			model.nextLevel();
			model.loadLevel();
			timer.start();
		});

		quitButton.addActionListener(e -> System.exit(0));

		setLayout(null);
		add(continueButton);
		add(quitButton);
		add(yesButton);
		add(noButton);

		try {
			BACKGROUND_IMG = new ImageIcon(getClass().getResource("backgroundImage.png")).getImage();
			THEME_IMG = new ImageIcon(getClass().getResource("theme.png")).getImage();

		} catch (Exception e) {
			System.out.println("Error loading background image: " + e.getMessage());
		}
		
		timer = new Timer(100, e -> {
			if (!model.playerLosingGame() && !model.playerWinGame()){
				continueButton.setVisible(false);
				quitButton.setVisible(false);
				yesButton.setVisible(false);
				noButton.setVisible(false);
				model.updateEnemy();
				repaint();
			}
			else if (model.playerFinishGame() || model.playerLosingGame()){
				yesButton.setVisible(true);
				noButton.setVisible(true);
			}
			else if (model.playerWinGame()){
				continueButton.setVisible(true);
				quitButton.setVisible(true);
				timer.stop();
			}
			else {
				timer.stop();
			}
			for	(GameEntity enemy : model.getEnemies()){
				if (model.handleCollision(model.getPlayer(), enemy)){
					model.resetPlayerPosition();
					model.playerLosesOneLive();
				}

				for (GameEntity block : model.getBlocks()){
					boolean hitX = ((Enemy) enemy).willCollideX(block);
					boolean hitY = ((Enemy) enemy).willCollideY(block);
					
					if (hitX){
						((Enemy) enemy).flipX();
						break;
					}

					if (hitY){
						((Enemy) enemy).flipY();
						break;
					}

				}
			}

		});
		timer.start();

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e){

				if (!model.isGameStarted()) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						model.startGame();
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
			g2.drawImage(THEME_IMG, -1, 0, getWidth(), getHeight() + 10, null);			
		}
	}
}