package model;

public interface Deck {
	public Card draw();
	//public boolean add(Card c);
	
	public void shuffle();
	
	public int getRemaining();
}
