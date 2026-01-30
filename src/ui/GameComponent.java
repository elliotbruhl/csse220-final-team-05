package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import model.*;

public class GameComponent extends JComponent {
	private GameModel model;
	private Image backgroundImg = new ImageIcon(getClass().getResource("backgroundImage.png")).getImage();
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
			public void keyReleased(KeyEvent e){
				if (e.getKeyCode() == KeyEvent.VK_W) {
					p.setDirection('W');
					p.move();
				}

				if (e.getKeyCode() == KeyEvent.VK_S) {
					p.setDirection('S');
					p.move();
				}
				if (e.getKeyCode() == KeyEvent.VK_A) {
					p.setDirection('A');
					p.move();
				}

				if (e.getKeyCode() == KeyEvent.VK_D) {
					p.setDirection('D');
					p.move();
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
		g2.drawImage(backgroundImg, 0, 0, getWidth(),  getHeight() , null);
		p.drawOn(g2);
		wall.drawOn(g2);
		enemy1.draw(g2);
		enemy2.draw(g2);
	}
}
