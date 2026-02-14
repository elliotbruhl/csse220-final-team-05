package ui;

import javax.swing.JFrame;

/**
 * Class: GameWindow
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: Creates and shows the main game window.
 */

public class GameWindow {
	public static void show() {
		JFrame frame = new JFrame("CSSE220 Final Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new GameComponent());
		frame.setSize(615, 630);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}