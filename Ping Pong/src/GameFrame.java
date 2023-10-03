import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class GameFrame extends JFrame {
	
	GamePanel panel;
	
	GameFrame(){
		
		panel = new GamePanel();
		this.add(panel);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("Ping Pong");
			this.setResizable(false);
			this.pack();
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			this.setBackground(Color.black);
			
	}

}
