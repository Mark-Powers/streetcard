package playingcards.crazyeights;

import java.util.List;

import model.Card;
import model.Hand;
import model.Player;
import playingcards.PlayingCard;
import playingcards.Value;

public class CrazyEightsPlayer extends Player {

	private CrazyEightsGame game;
	private String name;

	public CrazyEightsPlayer(String name, CrazyEightsGame game) {
		this.name = name;
		this.game = game;
		hand = new Hand();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void startTurn() {
		// do nothing
	}

	@Override
	public void doTurn() {

		int remove = 0;

		PlayingCard top = (PlayingCard) game.getTop();

		List<Card> handCards = hand.get();

		PlayingCard placeCard = playCrazyEightsCard(handCards, top);
		
		while (placeCard == null){
			hand.add(game.drawCard());
			handCards = hand.get();
			placeCard = playCrazyEightsCard(handCards, top);
		}

		game.place(placeCard);
		
		hand.discardIndex(remove);
	}

	private PlayingCard playCrazyEightsCard(List<Card> handCards, PlayingCard top) {
		for (int i = 0; i < hand.get().size(); i++) {
			PlayingCard card = (PlayingCard) handCards.get(i);
			if (card.getSuit().equals(top.getSuit())) {
				return card;
			}
			if (card.getValue().equals(top.getValue())) {
				return card;
			}
			if (card.getValue() == Value.EIGHT) {
				return card;
			}
		}
		return null;

	}

	@Override
	public void endTurn() {
		// do nothing
	}

	public int getNumberOfCards() {
		return hand.size();
	}

	public List<Card> getHandList() {
		return hand.get();
	}

}
