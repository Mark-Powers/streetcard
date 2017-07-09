package playingcards.kingscorner;

import java.util.ArrayList;

import model.Card;
import model.Hand;
import model.Player;
import playingcards.PlayingCard;
import playingcards.Value;

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
		System.out.print("\nBoard:\n");
		for (PlayingCard c : game.getBoardTop()) {
			if (c != null) {
				System.out.print(c.abbrv() + "\t");
			} else {
				System.out.print("___\t");
			}
		}
		System.out.println();
		for (PlayingCard c : game.getBoardBottom()) {
			if (c != null) {
				System.out.print(c.abbrv() + "\t");
			} else {
				System.out.print("___\t");
			}
		}
		System.out.println("\n");
		ArrayList<int[]> moves = possibleMoves();
		while (moves.size() > 0) {
			int[] move = moves.get(0);
			if (move[0] == 0) {
				System.out.println("Played " + ((PlayingCard) hand.get(move[1])).abbrv() + " at index " + move[2]);
				game.play((PlayingCard) hand.play(move[1]), move[2]);

			} else if (move[0] == 1) {
				System.out.println("Moved " + move[1] +" to " + move[2]);
				game.move(move[1], move[2]);
			}
			moves = possibleMoves();
		}
		System.out.println("\n");
	}

	@Override
	public void endTurn() {

	}

	public ArrayList<int[]> possibleMoves() {
		ArrayList<int[]> moves = new ArrayList<int[]>();
		// Get possible plays
		PlayingCard[] boardTop = game.getBoardTop();
		PlayingCard[] boardBottom = game.getBoardBottom();
		for (int i = 0; i < boardTop.length; i++) {
			PlayingCard boardTopCard = boardTop[i];

			for (int j = 0; j < hand.size(); j++) {
				PlayingCard handCard = (PlayingCard) hand.get(j);
				if ((boardTopCard == null && (handCard.getValue().equals(Value.KING) || i < 4)) || (boardTopCard != null
						&& boardTopCard.isOneHigherThan(handCard) && !boardTopCard.isSameColor(handCard))) {
					int[] move = new int[3];
					move[0] = 0;
					move[1] = j;
					move[2] = i;
					moves.add(move);
				}
			}

			for (int j = 0; j < boardTop.length; j++) {
				PlayingCard cardToMove = boardBottom[j];
				if (cardToMove != null && 
						((boardTopCard == null && i >= 4 && j < 4 && cardToMove.getValue().equals(Value.KING))
						|| (boardTopCard != null && boardTopCard.isOneHigherThan(cardToMove) && !boardTopCard.isSameColor(cardToMove)))) {
					int[] move = new int[3];
					move[0] = 1;
					move[1] = j;
					move[2] = i;
					moves.add(move);
				}
			}
		}
		return moves;
	}
}
