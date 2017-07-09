package gui;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.DrawableWithLocation;
import model.Game;

public class GamePanel extends JPanel {
	
	private Game game;
	
	
	public GamePanel(Game game) {
		this.game = game;
	}

	/**
	 * Draws the proper screen, probably just temporary
	 */
	public void paintComponent(Graphics g) {
		int xCenter = getWidth()/2;
		int yCenter = getHeight()/2;
				
		for(DrawableWithLocation dwl : game.getDrawableLocations()){
			dwl.point.translate(xCenter, yCenter);
			dwl.drawable.draw(g, dwl.point);
		}
		
	} 
}
