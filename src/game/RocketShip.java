package game;

import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject {

	int speed;
	boolean up, down, right, left;
	
	public RocketShip(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = -7;
	}
	
	public void update() {
		super.update();
		if (x + GamePanel.rocketImg.getWidth() / 2 < 0) x = LeagueInvaders.WIDTH - GamePanel.rocketImg.getWidth() / 2;
		if (x - GamePanel.rocketImg.getWidth() / 2 > LeagueInvaders.WIDTH) x = 0 - GamePanel.rocketImg.getWidth() / 2;
		if (y < 0) y = LeagueInvaders.HEIGHT;
		if (y > LeagueInvaders.HEIGHT - 80) y += speed;
		if (up) y += speed;
		if (down) y -= speed;
		if (right) x -= speed;
		if (left) x += speed;
	}
	
	public void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}
	
	public void setDirections(boolean u, boolean d, boolean r, boolean l) {
		up = u;
		down = d;
		right = r;
		left = l;
	}
	
}
