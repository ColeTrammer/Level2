package game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Window {
	public static final int width = 500;
	public static final int height = 800;
	
	JFrame frame;
	
	public Window() {
		frame = new JFrame();
		frame.setSize(width, height);
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
