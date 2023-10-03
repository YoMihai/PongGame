import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Scor extends Rectangle {
	
	static int LATIME;
	static int INALTIME;
	int player1;
	int player2;
	
	
	Scor(int LATIME , int INALTIME){
		Scor.LATIME = LATIME;
		Scor.INALTIME = INALTIME;
	}
	
	public void draw(Graphics g) {
		
		g.setFont(new Font("Consolas", Font.PLAIN, 60));
		g.setColor(Color.white);
		g.drawString(""+player1/10, (LATIME/2)-85, 60);
		g.drawString(""+player1%10, (LATIME/2)-50, 60);
		g.drawString(""+player2/10, (LATIME/2)+18, 60);
		g.drawString(""+player2%10, (LATIME/2)+53, 60);
		
		
		g.drawLine(LATIME/2, 0, LATIME/2, INALTIME);
		
	}

}