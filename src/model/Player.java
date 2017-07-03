package model;
public interface Player {
	
	public void giveCard(Card c);
	
	public String getName();
	public void startTurn();
	public void endTurn();
	public Card discard();
	public Card discardIndex(int index);
}
