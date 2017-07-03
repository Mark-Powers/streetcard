package gui;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	public GamePanel() {
	}

	/**
	 * Draws the proper screen, probably just temporary
	 */
	public void paintComponent(Graphics g) {
		g.setColor(new Color(255, 0, 0));
		g.fill3DRect(10, 10, 40, 40, false);
	}
}
