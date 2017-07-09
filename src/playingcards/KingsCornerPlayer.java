package playingcards;

import java.util.ArrayList;

import model.Card;
import model.Hand;
import model.Player;

public class KingsCornerPlayer extends Player {
	private String name;

	private KingsCornerGame game;

	public KingsCornerPlayer(String name, KingsCornerGame game) {
		this.name = name;
		this.game = game;
		hand = new Hand();
	}

	public int getNumberOfCards() {
		return hand.size();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void startTurn() {
		System.out.print(name + " Hand: ");
		hand.add(game.draw());
		for (Card c : hand.get()) {
			System.out.print(((PlayingCard) c).abbrv() + "\t");
		}
		System.out.println();
	}

	@Override
	public void doTurn() {
		System.out.print("Board: ");
		for (PlayingCard c : game.getBoard()) {
			if (c != null) {
				System.out.print(c.abbrv() + "\t");
			} else {
				System.out.print("___\t");
			}
		}
		System.out.println();
		ArrayList<int[]> moves = possibleMoves();
		while (moves.size() > 0) {
			int[] move = moves.get(0);
			System.out.println("Played " + ((PlayingCard) hand.get(move[1])).abbrv() + " at index " + move[2]);
			game.play((PlayingCard) hand.play(move[1]), move[2]);
			moves = possibleMoves();
		}
		System.out.println();
	}

	@Override
	public void endTurn() {

	}

	public ArrayList<int[]> possibleMoves() {
		ArrayList<int[]> moves = new ArrayList<int[]>();
		PlayingCard[] board = game.getBoard();
		for (int i = 0; i < board.length; i++) {
			PlayingCard boardCard = board[i];
			for (int j = 0; j < hand.size(); j++) {
				PlayingCard handCard = (PlayingCard) hand.get(j);
				if (i < 4) {
					if (board == null || (boardCard.isOneHigherThan(handCard) && !boardCard.isSameColor(handCard))) {
						int[] move = new int[3];
						move[0] = 0;
						move[1] = j;
						move[2] = i;
						moves.add(move);
					}

				} else {
					if (boardCard == null && handCard.getValue().equals(Value.KING)) {
						int[] move = new int[3];
						move[0] = 0;
						move[1] = j;
						move[2] = i;
						moves.add(move);
					} else if (boardCard != null
							&& (boardCard.isOneHigherThan(handCard) && !boardCard.isSameColor(handCard))) {
						int[] move = new int[3];
						move[0] = 0;
						move[1] = j;
						move[2] = i;
						moves.add(move);
					}

				}
			}
		}
		return moves;
	}
}
