package playingcards;

import java.util.List;

import model.Game;

public class KingsCornerGame extends Game {
	private PlayingCardDeck deck;
	private List<KingsCornerPlayer> players;
	int currentPlayer;
	
	public KingsCornerGame(List<KingsCornerPlayer> players){
		this.players = players;
		deck = new PlayingCardDeck();
		
		deck.deal(players, 7);
		
		currentPlayer = 0;
		//takeTurn();
	}
	
	public void takeTurn(){
		KingsCornerPlayer player = players.get(currentPlayer);
		player.startTurn();
		
		
		
		player.endTurn();
	}
	
}
