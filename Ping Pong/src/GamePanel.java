import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class GamePanel extends JPanel implements Runnable  {
	
	static final int LATIME = 1000;
	static final int INALTIME = (int)(LATIME*(0.5555));
	static final Dimension MARIME_MASA = new Dimension(LATIME, INALTIME);
	static final int DIAMETRU = 20;
	static final int PALETA_LATIME = 25;
	static final int PALETA_INALTIME = 100;
	
	
	Random random;
	Thread gameThread;
	Graphics graphics;
	Image image;
	Palete paleta1;
	Palete paleta2;
	Minge minge;
	Scor scor;

	
	
	
	GamePanel(){
		
		newBall();
		newPalete();
		scor = new Scor(LATIME, INALTIME);
		this.setFocusable(true);
		this.setPreferredSize(MARIME_MASA);
		this.addKeyListener(new ActionListener());
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	

	

	
	public void draw(Graphics g) {
		paleta1.draw(g);
		paleta2.draw(g);
		minge.draw(g);
		scor.draw(g);
		
	}
	
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0 , 0, this);
		
		
		
	}
	
	public void move() {
		
		paleta1.move();
		paleta2.move();
		minge.move();
		
			
	}
	
	public void checkCollision() {
		
		// nu ies paletele din window
		
		if(paleta1.y <= 0) {
			paleta1.y = 0;
		}
		
		if(paleta2.y <= 0) {
			paleta2.y = 0;
		}
		
		if(paleta1.y >= INALTIME-PALETA_INALTIME) {
			paleta1.y = INALTIME-PALETA_INALTIME;
		}
		if(paleta2.y >= INALTIME-PALETA_INALTIME) {
			paleta2.y = INALTIME-PALETA_INALTIME;
		}
		
		// minge sus jos
		
		if(minge.y <= 0) {
			minge.setYDirection(-minge.vitezaY);}
			
		 if(minge.y >= (INALTIME-DIAMETRU)) {
			 minge.setYDirection(-minge.vitezaY);
			 
		 }
		 
			 //scor
			 
			
			 
		if(minge.x <= 0) {
			
			newBall();
			newPalete();
			scor.player2++;
				
		}
		
	if(minge.x >= LATIME-DIAMETRU) {
			
			scor.player1++;
			newBall();
			newPalete();
	
			
			
		}
			
			
			
			
		
		
		// minge in palete
		
		if(minge.intersects(paleta1)) {
			
			 
			minge.vitezaX = Math.abs(minge.vitezaX);
			minge.vitezaX++; //DIFICULTATE
			if(minge.vitezaY > 0)
				minge.vitezaY++; //DIFICULTATE
			else minge.vitezaY--; //DIFICULTATE
			minge.setXDirection(minge.vitezaX);
			minge.setYDirection(minge.vitezaY);
			
		}
			
		if(minge.intersects(paleta2)) {
			
			minge.vitezaX = Math.abs(minge.vitezaX);
			minge.vitezaX++;
			if(minge.vitezaY > 0)
				minge.vitezaY++;
			else minge.vitezaY--;
			minge.setXDirection(-minge.vitezaX);
			minge.setYDirection(minge.vitezaY);
			
			
			
			
		}
			
			
		
	}
	
	public void newBall() {
		
		random = new Random();
	 minge = new Minge(LATIME/2 - DIAMETRU/2 , INALTIME/2 - DIAMETRU/2 , DIAMETRU, DIAMETRU);
	 
	 
	 
		
		
	}
	
	public void newPalete() {
		
		paleta1 = new Palete(0, (INALTIME/2 - PALETA_INALTIME/2) , PALETA_LATIME , PALETA_INALTIME, 1);
		paleta2 = new Palete((LATIME-PALETA_LATIME), (INALTIME/2 - PALETA_INALTIME/2) , PALETA_LATIME , PALETA_INALTIME, 2);
		
		
		
	}
	
	public void run() {
		
		//game loop
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 500000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			
			long now = System.nanoTime();
			delta+= (now - lastTime)/ns;
			lastTime = now;
			if(delta >= 1)
			{
				move();
				checkCollision();
				repaint();
				delta--;
				
		
			}
			
		}
		
		
		
		
	}
	
	
	public class ActionListener extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			
			paleta1.keyPressed(e);
			
			paleta2.keyPressed(e);
			
			
		}
		public void keyReleased(KeyEvent e) {
			paleta2.keyReleased(e);
			paleta1.keyReleased(e);
			
		}
		
		
	}
	
	
	

}
