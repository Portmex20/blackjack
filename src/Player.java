import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Player {
	boolean active;
	int handValue;
	String type;
	ArrayList<Card> hand = new ArrayList<Card>();
	
	public Player(Card card1, Card card2, String t){
		hand.add(card1);
		hand.add(card2);
		handValue = card1.getValue() + card2.getValue();
		type = t;
		active = false;
	}
	
	public void showCards(JFrame j, Graphics2D g2, int x, int y){
		if (type == "player" || (type == "dealer" && active == true)){
			for(int i=0; i<hand.size(); i++){
				int offset = i*50;
				hand.get(i).paintCard(j, g2, x + offset, y, true);
			}
		}
		else{
			for(int i=0; i<hand.size(); i++){
				int offset = i*50;
				if (i == 0)
					hand.get(i).paintCard(j, g2, x + offset, y, false);
				else
					hand.get(i).paintCard(j, g2, x + offset, y, true);
			}
		}
	}
	
	public int getHandValue(){
		return handValue;
	}
	
	public void addCard(Card c){
		hand.add(c);
		handValue += c.value; 
	}
	
	public void startTurn(){
		active = true;
	}
	
	public void endTurn(){
		active = false;
	}

	public Card getCard(int i){
		return hand.get(i);
	}
	
	public boolean isActive(){
		return active;
	}
	
	public boolean isBust(){
		return (handValue > 21);
	}
	
	public void newHand(Card c1, Card c2){
		hand.clear();
		addCard(c1);
		addCard(c2);
		handValue = c1.getValue() + c2.getValue();
	}
}
