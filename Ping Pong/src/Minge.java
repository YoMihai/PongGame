import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Minge extends Rectangle {
	
	Random random;
	int vitezaX;
	int vitezaY;
	int vitezainit = 2;
	
	Minge(int x , int y , int width, int height){
		
		super(x,y,width,height);
		random = new Random();
		int randomXDirection = random.nextInt(2);
		if(randomXDirection == 0)
		{
			randomXDirection--;
		}
			setXDirection(randomXDirection * vitezainit);
			
			
	
		
		
	
		int randomYDirection = random.nextInt(2);
		if(randomYDirection == 0)
		{
			randomYDirection--;}
			setYDirection(randomYDirection * vitezainit);
			
			
		
	
		
		
	}

	public void move() {
		
		x = x + vitezaX;
		y = y + vitezaY;
		
	}
	public void draw(Graphics g) {
		
		g.setColor(Color.white);
		g.fillOval(x, y, width, height);
		
		
	}

	
	public void setYDirection(int randomYDirection) {
		
		
		vitezaY = randomYDirection;
		
	}
	
	public void setXDirection(int randomXDirection) {
		vitezaX = randomXDirection;
	}
}
