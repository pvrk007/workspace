package pong;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Renderer extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2681429721806852947L;

	 protected void paintComponent(Graphics g)
	 {
		 super.paintComponent(g);
		 Pong.pong.render(g);
	 }
}
