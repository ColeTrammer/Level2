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
		speed = -5;
	}
	
	public void update() {
		super.update();
		if (up) y += speed;
		if (down) y -= speed;
		if (right) x -= speed;
		if (left) x += speed;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
	public void setDirections(boolean u, boolean d, boolean r, boolean l) {
		up = u;
		down = d;
		right = r;
		left = l;
	}
	
}
