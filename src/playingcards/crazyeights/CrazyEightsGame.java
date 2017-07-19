package playingcards.crazyeights;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.Card;
import model.DrawableWithLocation;
import model.Game;
import model.Player;
import playingcards.PlayingCard;
import playingcards.PlayingCardDeck;

public class CrazyEightsGame extends Game {

	private final int RADIUS = 180;
	
	private PlayingCardDeck deck;
	private List<CrazyEightsPlayer> players;
	private int currentPlayer;
	private Card top;
	
	public CrazyEightsGame() {
		players = new ArrayList<CrazyEightsPlayer>();
		deck = new PlayingCardDeck();
	}
	
	@Override
	public void startGame() {
		top = deck.draw();
		deck.deal(players, 7);
		
		while(!isOver()){
			CrazyEightsPlayer player = players.get(currentPlayer);
			System.out.println("---"+player.getName() + "'s Turn---");
			player.doTurn();
			currentPlayer = (currentPlayer + 1) % players.size();
		}
		
		onGameOver();
	}
	
	public void setPlayers(ArrayList<CrazyEightsPlayer> players) {
		this.players = players;
	}
	
	@Override
	public boolean isOver() {
		for (CrazyEightsPlayer player : players) {
			if (player.getNumberOfCards() == 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Player getWinner() {
		if (deck.getRemaining() <= 0){
			System.out.println("Ran out of cards in the deck.");
		}
		
		for (CrazyEightsPlayer player : players) {
			if (player.getNumberOfCards() == 0) {
				return player;
			}
		}
		return null;
	}

	@Override
	public void onGameOver() {
		System.out.println("\nPlayer " + getWinner().getName() + " has won!");
	}

	@Override
	public ArrayList<DrawableWithLocation> getDrawableLocations() {
		ArrayList<DrawableWithLocation> positions = new ArrayList<DrawableWithLocation>();
		positions.add(new DrawableWithLocation(deck, new Point(-40, 0)));
		positions.add(new DrawableWithLocation(top, new Point(40, 0)));

		for (int i = 0; i < players.size(); i++) {
			CrazyEightsPlayer player = players.get(i);
			
			List<Card> handList = player.getHandList();
			for (int handIndex = 0; handIndex < handList.size(); handIndex++) {
				Card card = handList.get(handIndex);
				Point p = getPointOnCircle(RADIUS, i, players.size());
				p.translate(handIndex*10 - handList.size()*5, 10*handIndex - handList.size()*5);
				positions.add(new DrawableWithLocation(card, p));
			}
			
		}
		
		return positions;
	}
	
	private Point getPointOnCircle(int radius, int i , int n) {
		int x = (int) (Math.cos(2 * Math.PI * (((float) i) / n)) * radius);
		int y = (int) (Math.sin(2 * Math.PI * (((float) i) / n)) * radius);
		return new Point(x, y);
	}

	public Card getTop(){
		return top;
	}

	public void place(PlayingCard card) {
		System.out.println("A " + card.abbrv() + " was placed.");
		top = card;
	}
	
	public PlayingCard drawCard(){
		return (PlayingCard) deck.draw();
	}
}
