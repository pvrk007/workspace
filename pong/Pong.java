package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Pong implements ActionListener, KeyListener
{

	public static  Pong pong;
	public int width = 700, height=700;
	public Renderer renderer;
	public Paddle player1;
	public Paddle player2;
	public boolean bot = false;
	public Ball ball;
	public boolean w, s, up, down;
	public int gameStatus =0;
	
	public Pong()
	{
	Timer timer = new Timer(20,this);
	JFrame jframe = new JFrame("Pong");
	renderer = new Renderer();
	jframe.setSize(width + 20, height);
	jframe.setVisible(true);
	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jframe.add(renderer);
	jframe.addKeyListener(this);
	start();
	timer.start();
	}
	
	public void start()
	{
		player1 = new Paddle(this, 1);
		player2 = new Paddle(this, 2);
		ball = new Ball(this);
	}
	public static void main(String[] args)
	{
		pong = new Pong();
	}
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect(0,0, width, height);
		if (gameStatus == 0)
		{
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", 1, 10));
			g.drawString("PONG", width/2-20, 50);;
		}
		else
		{	
		player1.render(g);
		player2.render(g);
		ball.render(g);
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(gameStatus ==1)
		{
		update();
		}
		renderer.repaint();
		
	}
	private void update() {
		// TODO Auto-generated method stub
		if(w)
		{
			player1.move(true);
		}
		if(s)
		{
			player1.move(false);
		}
		if(up)
		{
			player2.move(true);
		}
		if(down)
		{
			player2.move(false);
		}
		ball.update(player1, player2);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int id = e.getKeyCode();
		
		if(id==KeyEvent.VK_W)
		{
			w = true;
		}
		if(id==KeyEvent.VK_S)
		{
			s = true;
		}
		if(id==KeyEvent.VK_UP)
		{
			up = true;
		}
		if(id==KeyEvent.VK_DOWN)
		{
			down = true;
		}
		if(id==KeyEvent.VK_SPACE)
		{
			if(gameStatus==0)
			{
			gameStatus=1;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
int id = e.getKeyCode();
		
		if(id==KeyEvent.VK_W)
		{
			w = false;
		}
		if(id==KeyEvent.VK_S)
		{
			s = false;
		}
		if(id==KeyEvent.VK_UP)
		{
			up = false;
		}
		if(id==KeyEvent.VK_DOWN)
		{
			down = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
