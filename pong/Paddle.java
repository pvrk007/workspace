package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {


	public int paddleNumber;
	public int x, y, width = 30, height = 200;
	public int score;
	public Paddle(Pong pong, int paddleNumber)
	{
		this.paddleNumber = paddleNumber;
		
		if (paddleNumber ==1)
		{
			this.x=0;
		}
		if(paddleNumber ==2)
		{
			this.x = pong.width - width;
		
		}
		this.y =  pong.height /2 - this.height / 2;
	}
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		
	}
	public void move(boolean up) {
		// TODO Auto-generated method stub
		int speed = 15;
		
		if(up)
		{
						
			if(y-speed > 0)
			{
				y-=speed;
			}
			else
			{
				y=0;
			}
		}
		else
		{
			if(y+height+speed < Pong.pong.height)
			{
				y+=speed;
			}
			else
			{
				y = Pong.pong.height - height-15;
			}
		}
	}
	public void move1 (boolean up) {
		// TODO Auto-generated method stub
		
	}

}
