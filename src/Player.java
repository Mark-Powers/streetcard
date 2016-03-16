import java.util.ArrayList;

public class Player {
	private CardStack deck;
	private ArrayList<Card> hand;
	private String name;
	private boolean isAlive;
	
	/**
	 * Basic player constructor
	 * @param c A deck of cards, to be used as the deck. c will be shuffled before making it the deck.
	 * @param n The name of the player
	 */
	public Player(ArrayList<Card> c, String deckName, String n){
		name = n;
		isAlive = true;
		hand = new ArrayList<Card>();
		deck  = new CardStack(deckName);
		deck.addAll(c);
		deck.shuffle();
	}
	
	/**
	 * Moves a card from the deck to the hand.
	 * @return True if the deck was not empty.
	 */
	public boolean draw(){
		if(!deck.isEmpty()){
			hand.add(deck.pop());
			return true;
		}
		return false;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean isAlive(){
		return isAlive;
	}
}
