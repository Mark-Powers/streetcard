package playingcards.kingscorner;

import java.util.ArrayList;
import java.util.List;

import model.Game;
import model.Player;
import playingcards.PlayingCard;
import playingcards.PlayingCardDeck;
import playingcards.Value;

public class KingsCornerGame extends Game {
	private PlayingCardDeck deck;
	private List<KingsCornerPlayer> players;
	private PlayingCard[] boardTop;
	private PlayingCard[] boardBottom;
	private int currentPlayer;

	public KingsCornerGame() {
		players = new ArrayList<KingsCornerPlayer>();
		deck = new PlayingCardDeck();
		boardTop = new PlayingCard[8];
		boardBottom = new PlayingCard[8];

		currentPlayer = 0;
	}

	public void setPlayers(List<KingsCornerPlayer> players) {
		this.players = players;
	}

	@Override
	public void startGame() {
		deck.deal(players, 7);

		for (int i = 0; i < 4; i++) {
			boardTop[i] = draw();
			boardBottom[i] = boardTop[i];
		}

		while (!isOver()) {
			takeTurn();
			currentPlayer = (currentPlayer + 1) % players.size();
		}
		onGameOver();
	}

	public void takeTurn() {
		KingsCornerPlayer player = players.get(currentPlayer);
		player.startTurn();
		player.doTurn();
		player.endTurn();
	}

	public PlayingCard draw() {
		return (PlayingCard) deck.draw();
	}

	public PlayingCard[] getBoardTop() {
		return boardTop;
	}

	public PlayingCard[] getBoardBottom() {
		return boardBottom;
	}

	public boolean play(PlayingCard card, int index) {
		PlayingCard bottom = boardTop[index];
		// Played a card in a null spot
		if (boardTop[index] == null && (card.getValue().equals(Value.KING) || index < 4)) {
			boardTop[index] = card;
			boardBottom[index] = card;
			return true;
		}
		// Played a card on top of another
		if (bottom.isOneHigherThan(card) && !bottom.isSameColor(card)) {
			boardTop[index] = card;
			return true;
		}
		return false;
	}

	public boolean move(int from, int to) {
		PlayingCard cardToMove = boardBottom[from];
		PlayingCard cardStaying = boardTop[to];
		// First condition is moving to a null space
		// Second condition is moving onto another
		if ((cardStaying == null && (to < 4 || cardToMove.getValue().equals(Value.KING)))
				|| (cardStaying.isOneHigherThan(cardToMove) && !cardStaying.isSameColor(cardToMove))) {
			boardTop[to] = boardTop[from];
			boardBottom[to] = boardBottom[from];
			boardTop[from] = null;
			boardBottom[from] = null;
			return true;
		}
		return false;
	}

	@Override
	public boolean isOver() {
		for (KingsCornerPlayer player : players) {
			if (player.getNumberOfCards() == 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Player getWinner() {
		for (KingsCornerPlayer player : players) {
			if (player.getNumberOfCards() == 0) {
				return player;
			}
		}
		return null;
	}

	@Override
	public void onGameOver() {
		System.out.println("Player " + getWinner().getName() + " has won!");
	}
}
