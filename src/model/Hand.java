package model;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards;

	public Hand() {
		cards = new ArrayList<Card>();
	}

	public Card play(int index) {
		return cards.remove(index);
	}

	public void add(Card c) {
		cards.add(c);
	}

	public Card discardRandom() {
		return cards.remove((int) (Math.random() * cards.size()));
	}

	public Card discardIndex(int index) {
		return cards.remove(index);
	}

	public int size() {
		return cards.size();
	}
	
	public ArrayList<Card> get(){
		return cards;
	}
	
	public Card get(int index){
		return cards.get(index);
	}
}
