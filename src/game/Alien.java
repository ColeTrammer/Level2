package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject {

	private int counter;
	boolean right;
	Random r;
	
	public Alien(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		r = new Random();
		right = r.nextBoolean();
	}
	
	public void update() {
		super.update();
		y++;
		counter++;
		if (counter > 10) {
			right = r.nextBoolean();
			counter = 0;
		}
		if (right) {
			x++;
		}
		else {
			x--;
		}
		if (y > LeagueInvaders.HEIGHT) {
			isAlive = false;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
	
}
