package playingcards;

public enum Suit {
	CLUBS ("Clubs", Color.BLACK),	
	SPADES ("Spades", Color.BLACK),
	DIAMONDS ("Diamonds", Color.RED),
	HEARTS ("Hearts", Color.RED);
	
	
	private final String name;
	private final Color color;
	
	Suit(String name, Color color){
		this.name= name;
		this.color = color;
	}
	
	public boolean isSameColor(Suit other){
		return this.color.equals(other.color);
	}
	
	@Override
	public String toString(){
		return name;
	}
}
