package playingcards;

import java.util.ArrayList;
import java.util.List;

import model.Game;
import model.Player;

public class KingsCornerGame extends Game {
	private PlayingCardDeck deck;
	private List<KingsCornerPlayer> players;
	private PlayingCard[] board;
	int currentPlayer;

	public KingsCornerGame() {
		players = new ArrayList<KingsCornerPlayer>();
		deck = new PlayingCardDeck();
		board = new PlayingCard[8];

		currentPlayer = 0;
	}

	public void setPlayers(List<KingsCornerPlayer> players) {
		this.players = players;
	}

	@Override
	public void startGame() {
		deck.deal(players, 7);

		for (int i = 0; i < 4; i++) {
			board[i] = draw();
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

	public PlayingCard[] getBoard() {
		return board;
	}

	public boolean play(PlayingCard card, int index) {
		PlayingCard bottom = board[index];
		if (board[index] == null && (card.getValue().equals(Value.KING) || index < 4)) {
			board[index] = card;
			return true;
		}
		if (bottom.isOneHigherThan(card) && !bottom.isSameColor(card)) {
			board[index] = card;
			return true;
		}
		return false;
	}

	public boolean move(int from, int to) {
		PlayingCard card = board[from];
		PlayingCard bottom = board[to];
		if ((bottom == null && card.getValue().equals(Value.KING))
				|| (bottom.isOneHigherThan(card) && !bottom.isSameColor(card))) {
			board[to] = card;
			board[from] = null;
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
