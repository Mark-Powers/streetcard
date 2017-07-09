package model;

public abstract class Player {
	protected Hand hand;

	public abstract String getName();

	public abstract void startTurn();

	public abstract void doTurn();

	public abstract void endTurn();

	public Card discard() {
		return hand.discardRandom();
	}

	public Card discardIndex(int index) {
		return hand.discardIndex(index);
	}
	
	public void giveCard(Card c){
		hand.add(c);
	}
}
