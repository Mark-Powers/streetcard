package gui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import model.Card;
import model.DrawableWithLocation;
import model.Game;
import playingcards.PlayingCard;

public class GamePanel extends JPanel {

	private Game game;

	public GamePanel(Game game) {
		this.game = game;

		this.addMouseListener(new GameMouseListener());
	}

	/**
	 * Draws the proper screen, probably just temporary
	 */
	@Override
	public void paintComponent(Graphics g) {
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;

		for (DrawableWithLocation dwl : game.getDrawableLocations()) {
			dwl.point.translate(xCenter, yCenter);
			dwl.drawable.draw(g, dwl.point);
		}

	}

	private class GameMouseListener extends MouseAdapter implements MouseMotionListener {

		private Card selected;

		@Override
		public void mouseExited(MouseEvent e) {
			selected = null;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("\nPressed!");
			selected = new PlayingCard(null, null);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			int xCenter = getWidth() / 2;
			int yCenter = getHeight() / 2;
			Point mousePoint = e.getPoint();
			mousePoint.translate(-xCenter, -yCenter);

			System.out.println("Trying to play...");
			if (selected != null && game.play(mousePoint, selected)) {
				System.out.println("Valid play");
			}
			selected = null;
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

	}
}
