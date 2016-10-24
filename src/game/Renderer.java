package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.sun.prism.Graphics;

public class Renderer extends JPanel implements ActionListener {

	Timer timer;
	
	public Renderer() {
		timer = new Timer(1000 / 60, this);
	}

	public void start() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		g.fillRect(10, 10, 100, 100);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
}
