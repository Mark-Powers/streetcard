package playingcards;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import model.Card;

public class PlayingCard extends Card {
	private final int HEIGHT = 90;
	private final int WIDTH = 70;
	
	private Suit suit;
	private Value value;
	private static Font plainFont = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
	private static Font suitFont =  new Font(Font.MONOSPACED, Font.PLAIN, 36);

	public PlayingCard(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}

	public Suit getSuit() {
		return suit;
	}

	public Value getValue() {
		return value;
	}

	public boolean isSameColor(PlayingCard other) {
		return suit.isSameColor(other.getSuit());
	}

	public boolean isOneHigherThan(PlayingCard other) {
		return value.ordinal() - other.getValue().ordinal() == 1;
	}

	@Override
	public String name() {
		return value.toString() + " of " + suit.toString();
	}
	
	public String abbrv(){
		return suit.toString().charAt(0) + "-" + value.toString();
	}

	@Override
	public void draw(Graphics g, Point topLeft) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(topLeft.x, topLeft.y, WIDTH, HEIGHT);
		g.setColor(Color.WHITE);
		g.fillRect(topLeft.x+5, topLeft.y+5, WIDTH-10, HEIGHT-10);
		g.setColor(Color.BLACK);
		g.setFont(plainFont);
		g.drawString(abbrv(), topLeft.x+5, topLeft.y + 5 + 12);
		g.setFont(suitFont);
		g.drawString(String.valueOf(suit.getCodepoint()), topLeft.x + 20, topLeft.y + 60);
		g.setFont(plainFont);
	}
}
