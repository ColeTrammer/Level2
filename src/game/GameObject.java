package game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {

	int x, y, width, height;
	boolean isAlive = true;
	Rectangle collisionBox;
	
	public GameObject() {
		collisionBox = new Rectangle(x, y, width, height);
	}
	
	public void update() {
		collisionBox.setBounds(x, y, width, height);
	}
	
	public void draw(Graphics g) {

	}
	
}
