package model;

public abstract class Deck implements Drawable {
	public abstract Card draw();
	// public boolean add(Card c);
	public abstract void shuffle();
	public abstract int getRemaining();
}
