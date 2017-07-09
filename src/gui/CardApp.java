package gui;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.UIManager;

import playingcards.kingscorner.KingsCornerGame;
import playingcards.kingscorner.KingsCornerPlayer;


public class CardApp {
	
	public static final int width = 1080;
	public static final int height = 720;
	public static final String title = "A Card Game";
	
	public static void main(String args[]){
		KingsCornerGame game = new KingsCornerGame();
		ArrayList<KingsCornerPlayer> players = new ArrayList<KingsCornerPlayer>();
		players.add(new KingsCornerPlayer("1", game));
		players.add(new KingsCornerPlayer("2", game));
		game.setPlayers(players);
		game.startGame();
		
		//new CardApp();
	}
	
	JFrame frame;
	
	public CardApp(){
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setTitle(title);		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e){
			System.out.println("Guess we are going with java's defualt.");
		}
		
		frame.add(new GamePanel(), BorderLayout.CENTER);
				
		frame.pack();
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
