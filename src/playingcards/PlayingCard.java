package playingcards;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import model.Card;

public class PlayingCard extends Card {
	public static final int HEIGHT = 90;
	public static final int WIDTH = 70;
	
	private Suit suit;
	private Value value;

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
		g.drawString(abbrv(), topLeft.x+5, topLeft.y + 5 + 12);
	}
}
