import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Deck{
	final int DECKSIZE = 52;
	
	static ArrayList<Card> cards;
	
	public Deck(){		
		cards = new ArrayList<Card>();
		int cardCount = 0;
		int index = 0;
		int suitRank = 0;
		
		while (cardCount < DECKSIZE){
			cards.add(new Card(index, suitRank));
			
			if (index == 12){
				index = 0;
				suitRank++;
			}

			else
				index++;
			
			cardCount++;
		}
	}
	
	public void shuffle(){
		ArrayList<Card> shuffledCards = new ArrayList<Card>();
		
		Random r = new Random();
		
		for (int i=0; i<DECKSIZE; i++){
			int index = r.nextInt(DECKSIZE-i);
			shuffledCards.add(cards.remove(index));
		}
		
		cards = shuffledCards;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<DECKSIZE; i++){
			sb.append(cards.get(i) + " ");
		}
		
		sb.append("\n");
		
		return sb.toString();
	}
	
	public Card getCard(int index){
		return cards.get(index);
	}
	
	public static void main(String [] args){
		Deck myDeck = new Deck();
		myDeck.shuffle();
		System.out.println(myDeck);
	}

}
