package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener, KeyListener {

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;

	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	public static BufferedImage spaceImg;
	
	private int currentState = MENU_STATE;
	boolean up, down, left, right, spacebar;
	Timer timer;
	RocketShip ship;
	Font titleFont;
	Font headerFont;
	ObjectManager manager;
	
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		headerFont = new Font("Arial", Font.PLAIN, 24);
		timer = new Timer(1000 / 60, this);
		ship = new RocketShip(250, 700, 50, 50);
		manager = new ObjectManager();
		manager.addObject(ship);
		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
			spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g){
		switch (currentState) {
			case MENU_STATE: drawMenuState(g); return;
			case GAME_STATE: drawGameState(g); return;
			case END_STATE: drawEndState(g); return;
		}
	}
	
	public void updateMenuState() {
		
	}
	
	public void updateGameState() {
		ship.setDirections(up, down, right, left);
		if (spacebar) manager.addObject(new Projectile(ship.x + ship.width / 2 - 5, ship.y, 10, 10));
		manager.updateObjects();
		if (!ship.isAlive || Alien.isPast) {
			currentState = END_STATE;
		}
	}
	
	public void updateEndState() {
		
	}
	
	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 10, 200);
		g.setFont(headerFont);
		g.drawString("Press ENTER to start", 150, 300);
		g.drawString("Press SPACE for instructions", 120, 400);
	}
	
	public void drawGameState(Graphics g) {
		g.drawImage(spaceImg, 0, 0, null);
		manager.drawObjects(g);
	}
	
	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 120, 100);
		g.setFont(headerFont);
		g.drawString("You killed " + manager.getScore() + " aliens.", 150, 300);
		g.drawString("Press ENTER to restart", 100, 500);
	}
	
	public void startGame() {
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		switch (currentState) {
			case MENU_STATE: updateMenuState(); return;
			case GAME_STATE: updateGameState(); return;
			case END_STATE: updateEndState(); return;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) up = true;
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) down = true; 
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = true;
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) left = true;
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) spacebar = true;
		else {
			currentState++;
			if (currentState > END_STATE) {
				currentState = 0;
				ship = new RocketShip(250, 700, 50, 50);
				manager.reset();
				manager.addObject(ship);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) up = false;
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) down = false; 
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = false;
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) left = false;
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) spacebar = false;
	}
	
}
