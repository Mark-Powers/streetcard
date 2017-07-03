package model;
/**
 * @author Mark
 */
public interface Effect {
//	// Used to check when the effect is activated
//	// 0 - on play
//	// 1 - on click (i.e. 'tap')
//	int time;
//	// What thing does this effect do.
//	int type;
//	String text; 
//	
	public void affect(int state);
	
	
}
