package playingcards;

import model.Card;
import model.Hand;
import model.Player;

public class KingsCornerPlayer implements Player {

	private String name;
	private PlayingCardDeck deck;
	private Hand hand;
	
	public KingsCornerPlayer(String name, PlayingCardDeck deck) {
		this.name = name;
		this.deck = deck;
		hand = new Hand();
	}
	
	@Override
	public void giveCard(Card c) {
		hand.add(c);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void startTurn() {
		hand.add(deck.draw());
	}

	@Override
	public void endTurn() {
		
	}

	@Override
	public Card discard() {
		return hand.discardRandom();
	}

	@Override
	public Card discardIndex(int index) {
		return hand.discardIndex(index);
	}
}
