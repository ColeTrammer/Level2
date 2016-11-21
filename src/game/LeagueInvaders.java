package game;

import javax.swing.JFrame;

public class LeagueInvaders {

	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
	JFrame frame;
	GamePanel gamePanel;
	
	public LeagueInvaders() {
		frame = new JFrame();
		gamePanel = new GamePanel();
		frame.addKeyListener(gamePanel);
		setup();
	}
	
	private void setup() {
		frame.add(gamePanel);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(GamePanel.alienImg);
		gamePanel.startGame();
	}
	
	public static void main(String[] args) {
		new LeagueInvaders();
		
	}
	
}
