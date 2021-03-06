package playingcards;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import model.Card;
import model.Deck;
import model.Player;

public class PlayingCardDeck extends Deck {
	private final int HEIGHT = 60;
	private final int WIDTH = 50;
	
	
	private LinkedList<PlayingCard> cards;
	
	public PlayingCardDeck(){
		cards = new LinkedList<PlayingCard>();
		
		for(Suit s : Suit.values()){
			for(Value v : Value.values()){
				cards.add(new PlayingCard(s, v));
			}
		}
		shuffle();
	}
	
	@Override
	public Card draw() {
		return cards.pop();
	}

	@Override
	public void shuffle() {
		Collections.shuffle(cards);
	}

	@Override
	public int getRemaining() {
		return cards.size();
	}
	
	public void deal(List<? extends Player> players, int amount){
		if(players.size()*amount > cards.size()){
			throw new RuntimeException("Not enough cards! " + cards.size());
		}
		for(int i = 0; i<amount; i++){
			for(Player p : players){
				p.giveCard(draw());
			}
		}
	}

	@Override
	public void draw(Graphics g, Point topLeft) {
		g.setColor(Color.GREEN);
		g.fillRect(topLeft.x, topLeft.y, WIDTH, HEIGHT);
	}
}
