package game;

import javax.swing.JFrame;

public class ResourceManager {

	Window window;
	Renderer renderer;
	
	public ResourceManager() {
		window = new Window();
		renderer = new Renderer();
		window.addRenderer(renderer);
	}
	
	public void start() {
		renderer.start();
	}
	
}
