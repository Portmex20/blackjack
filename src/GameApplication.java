import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class GameApplication extends JFrame{
	BlackJackGame myGame;
	Rectangle2D.Double backgroundRectangle;
	
	public GameApplication(){
		addKeyListener( new GameKeyListener() );
		myGame = new BlackJackGame(this);
		myGame.startGame();
		backgroundRectangle = new Rectangle2D.Double( 0, 0, 800, 600 );
	}
	
	public static void main(String[] args){
		GameApplication ga = new GameApplication();
		
		ga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ga.setSize(800, 600);
		ga.setVisible( true );
		ga.setBackground(Color.decode("#009900"));
		ga.setTitle("BlackJack 1.0");
	}

	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.decode("#009900"));
		g2.fill( backgroundRectangle );
		myGame.paintGame(g2);
	}
	
	private class GameKeyListener implements KeyListener{
		public void keyPressed(KeyEvent event){
			switch (event.getKeyCode()){
			case KeyEvent.VK_H:
				myGame.userInput("hit");
				break;
			case KeyEvent.VK_S:
				myGame.userInput("stick");
				break;
			case KeyEvent.VK_D:
				myGame.userInput("dealer");
				break;
			case KeyEvent.VK_N:
				myGame.userInput("nextHand");
				break;
			}
		}
		
		public void keyTyped(KeyEvent event){}
		public void keyReleased(KeyEvent event){}
	}

}
