package game;

import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject {

	public static boolean isPast = false;
	private int counter;
	boolean right;
	int speed;
	Random r;
	
	public Alien(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		r = new Random();
		right = r.nextBoolean();
		speed = 2;
	}
	
	public void update() {
		super.update();
		y++;
		counter++;
		if (counter > 25) {
			right = r.nextBoolean();
			counter = 0;
		}
		if (x + GamePanel.alienImg.getWidth() / 2 < 0 && !right) right = true;
		if (x + GamePanel.alienImg.getWidth() / 2 > LeagueInvaders.WIDTH && right) right = false;
		if (right) {
			x += speed;
		}
		else {
			x -= speed;
		}
		if (y > LeagueInvaders.HEIGHT - 20) {
			isAlive = false;
			isPast = true;
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
	
}
