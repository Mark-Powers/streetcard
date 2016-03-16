import java.util.ArrayList;


public class Card {
	private ArrayList<Effect> effects;
	private String title;
	private String text;
	
	public Card(String myTitle, String myText, ArrayList<Effect> e){
		title = myTitle;
		text = myText;
		effects = e;
	}
	
	public void play(int state){
		for(Effect e : effects){
			e.affect(state);
		}
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getText(){
		return text;
	}
}
