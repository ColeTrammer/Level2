package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	
	
	ArrayList<GameObject> objects;
	Random r;
	int score, ran;
	
	public ObjectManager() {
		objects = new ArrayList<GameObject>();
		r = new Random();
		ran = 40;
		//ran = 1;
	}
	
	public void addObject(GameObject object) {
		objects.add(object);
	}
	
	public void updateObjects() {
		manageEnemies();
		checkCollision();
		for (GameObject object : objects) {
			object.update();
		}
		purgeObjects();
	}
	
	public void drawObjects(Graphics g) {
		for (GameObject object : objects) {
			object.draw(g);
		}
	}
	
	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}
	
	private void manageEnemies() {
		if (ran < 10) ran = 10;
		if (r.nextInt(ran) == 0) {
			objects.add(new Alien(r.nextInt(LeagueInvaders.WIDTH), 10, 25, 25));
		}
	}
	
	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				
				if(o1.collisionBox.intersects(o2.collisionBox)){
					if((o1 instanceof Alien && o2 instanceof Projectile) ||
					   (o2 instanceof Alien && o1 instanceof Projectile)){
						score++;
						ran--;
						o1.isAlive = false;
						o2.isAlive = false;
					}
					else if((o1 instanceof Alien && o2 instanceof RocketShip) ||
							(o2 instanceof Alien && o1 instanceof RocketShip)){
						o1.isAlive = false;
						o2.isAlive = false;
					}
	
				}
			}
		}
	}

	public void reset() {
		objects.clear();
		score = 0;
	}
	
	public int getScore() {
		return score;
	}
	
}
