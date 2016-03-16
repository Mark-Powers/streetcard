import java.util.Collection;
import java.util.Collections;
import java.util.Stack;


/**
 * A data structure used for the deck, mostly for code readability.
 * @author Mark
 *
 */
public class CardStack {
	Stack<Card> cards;
	String name;
	
	public CardStack(String n) {
		name = n;
		cards = new Stack<Card>();
	}
	
	public void addAll(Collection<Card> c){
		cards.addAll(c);
	}
	
	public boolean isEmpty(){
		return cards.isEmpty();
	}
	
	public void push(Card c){
		cards.push(c);
	}
	
	public Card pop(){
		return cards.pop();
	}
	
	public int size(){
		return cards.size();
	}
	
	public void shuffle(){
		Collections.shuffle(cards);
	}
	
}
