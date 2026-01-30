package ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.Timer;
import model.*;

/**
 * Class: GameComponent
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: This class is responsible for rendering the game state and handling user input.
 */

public class GameComponent extends JComponent {
	private GameModel model;
	private final Image BACKGROUND_IMG = new ImageIcon(getClass().getResource("backgroundImage.png")).getImage();
	private Player p;
	private Wall wall;
	private Enemy enemy1;
	private Enemy enemy2;

	public GameComponent(GameModel model) {
		this.model = model;
		wall = new Wall();
		p = new Player();
		enemy1 = new Enemy(100, 100, 30, 30);
		enemy2 = new Enemy(200, 200, 30, 30);
		Timer timer = new Timer(100, e -> {
			enemy1.moveX();
			enemy2.moveY();
			repaint();
		});
		timer.start();
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {}
            @Override
			public void keyReleased(KeyEvent e){
				switch(e.getKeyCode()) {
					case KeyEvent.VK_W -> p.setDirection('W');
					case KeyEvent.VK_S -> p.setDirection('S');
					case KeyEvent.VK_A -> p.setDirection('A');
					case KeyEvent.VK_D -> p.setDirection('D');
				}
				p.move();
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
		p.drawOn(g2);
		wall.drawOn(g2);
		enemy1.draw(g2);
		enemy2.draw(g2);
	}
}
