package game;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ResourceManager {

	Window window;
	Renderer renderer;
	
	public ResourceManager() {
		window = new Window();
		renderer = new Renderer();
		
		//window.addRenderer(renderer);
	}
	
	public void start() {
		window.add(new JLabel("100asdf"));
		renderer.start();
	}
	
}
