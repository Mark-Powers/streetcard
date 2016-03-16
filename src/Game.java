import java.util.ArrayList;
import java.util.Collections;


public class Game {
	ArrayList<Player> players;
	// 0 - pre-game
	// 1 - during game
	// 2 - post game
	private int gameState;
	// 0 Playing cards
	// 1 Using played cards
	// 2 Ending/second play phase
	private int turnState;
	
	public Game(){
		gameState = 0;
	}
	
	/**
	 * @param p Player to add to the players for this game
	 */
	public void addPlayer(Player p){
		players.add(p);
	}
	
	/**
	 * Shuffles the players, and starts the game
	 */
	public void startGame(){
		Collections.shuffle(players);
		gameState = 1;
	}
	
	/**
	 * Checks if only one player is alive
	 * @return true if 1 or less players are alive.
	 */
	public boolean isOver(){
		int playersAlive = 0;
		for(Player p : players){
			if(p.isAlive()){
				playersAlive++;
			}
		}
		return playersAlive < 2;
	}
	
	public void round(){
		for(Player p : players){
			turnState = 0;
			p.draw();
			
			
		}
	}
	
	public int getGameState(){
		return gameState;
	}
	
	public int getTurnState(){
		return turnState;
	}
	
	public void nextTurnState(){
		turnState++;
	}
}
