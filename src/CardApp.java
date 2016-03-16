import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;


public class CardApp {
	
	public static final int width = 1080;
	public static final int height = 720;
	public static final String title = "A Card Game";
	
	public static void main(String args[]){
		new CardApp();
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
