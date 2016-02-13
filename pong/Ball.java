package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
	public int x, y, width = 25, height = 25;
	public int motionX, motionY;
	private Pong pong;
	public Random random;
	public Ball(Pong pong)
	{
		this.pong = pong;
		
		random = new Random();
		this.x = pong.width/2;
		this.y = pong.height /2 - this.height / 2;
		this.motionY = -2 + random.nextInt(4);
		this.motionX = -2 + random.nextInt(1);
		if (motionY == 0)
		{
			motionY =1;
		}
		if (random.nextBoolean())
		{
			motionX =7;
			motionY =7;
		}
		else
		{
			motionX = -7;
			motionY = -7;
		}
	}
	public void update(Paddle paddle1, Paddle paddle2)
	{
		this.x +=motionX;
		this.y +=motionY;

		 if (this.y< pong.height || this.y + height > 0 )
		 {
			 if(this.motionY<0)
			 {
				 this.motionY = random.nextInt(4);
			 }
			 else
			 {
				 this.motionY = -random.nextInt(4);
			 }
			 
		 {
			this.motionY =random.nextInt(4);
		 }
		 
		if (checkCollision(paddle1)==1)
		{
			this.motionX =1;
			this.motionY = -2 + random.nextInt(4);
		}
		if (checkCollision(paddle2)==1)
		{
			this.motionX =1;
			this.motionY = -2 + random.nextInt(4);
		}
		if (checkCollision(paddle1)==2)
		{
			paddle2.score++;
		}
		else if (checkCollision(paddle2) ==2)
		{
			paddle1.score++;
		}
		 }
	} 
	
	public int checkCollision(Paddle paddle)
	{
	 if (this.x<paddle.x + width && this.x + width > paddle.x && this.y<paddle.y + width && this.y + width > paddle.y )
	 {
		 return 1;
	 }
	 else if ((paddle.x>x+width && paddle.paddleNumber ==1) || (paddle.x<x && paddle.paddleNumber == 2 ))
	 {
		 return 2;
	 }
	 return 0;
	}
	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(x, y, width, height);
	}

}
