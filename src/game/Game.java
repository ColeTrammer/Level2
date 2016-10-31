package game;

public class Game {

	ResourceManager rm;
	
	public Game() {
		rm = new ResourceManager();
		rm.start();
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}
