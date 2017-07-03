package playingcards;

public enum Value {
	ACE,
	ONE,
	TWO,
	THREE,
	FOUR,
	FIVE,
	SIX, 
	SEVEN,
	EIGHT,
	NINE,
	TEN,
	JACK,
	QUEEN,
	KING;
	
	@Override
	public String toString(){
		return name().substring(0, 1).toUpperCase() + name().toLowerCase();
	}
}
