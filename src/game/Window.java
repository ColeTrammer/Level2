package game;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Window {
	public static final int width = 800;
	public static final int height = 600;
	
	JFrame frame;
	
	public Window() {
		frame = new JFrame();
		frame.setSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void add(JComponent c) {
		frame.add(c);
	}
	
	public void addRenderer(Renderer renderer) {
		add(renderer);
	}
	
}
