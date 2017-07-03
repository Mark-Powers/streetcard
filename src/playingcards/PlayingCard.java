package playingcards;

import model.Card;

public class PlayingCard implements Card {
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

	public boolean isHigherThen(PlayingCard other) {
		return value.ordinal() - other.getValue().ordinal() > 0;
	}

	public String name() {
		return value.toString() + " of " + suit.toString();
	}
}
