package playingcards;

public enum Suit {
	CLUBS ("Clubs", Color.BLACK, '\u2663'),	
	SPADES ("Spades", Color.BLACK, '\u2660'),
	DIAMONDS ("Diamonds", Color.RED, '\u2666'),
	HEARTS ("Hearts", Color.RED, '\u2665');
	
	
	private final String name;
	private final Color color;
	private char codepoint;
	
	Suit(String name, Color color, char codepoint){
		this.name= name;
		this.color = color;
		this.codepoint = codepoint;
	}
	
	public boolean isSameColor(Suit other){
		return this.color.equals(other.color);
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	public char getCodepoint(){
		return codepoint;
	}
}
