/**
 * A abstract class that is a generic effect.
 * @author Mark
 */
public abstract class Effect {
	// Used to check when the effect is activated
	// 0 - on play
	// 1 - on click (i.e. 'tap')
	int time;
	// What thing does this effect do.
	int type;
	String text; 
	
	public abstract void affect(int state);
}
