package ui;

import javax.swing.JFrame;
import model.GameModel;

/**
 * Class: GameWindow
 * @author The Button Mashers - Elliot Bruhl, Jonathon Hammond, Josh Max, Phu Bui
 * <br>Purpose: Creates and shows the main game window.
 */

public class GameWindow {
	public static void show() {
		GameModel model = new GameModel();
		JFrame frame = new JFrame("CSSE220 Final Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new GameComponent(model));
		frame.setSize(615, 655);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}