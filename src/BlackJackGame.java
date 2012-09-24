import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class BlackJackGame{
	GameApplication myApp;
	Deck gameDeck;
	Player player1;
	Player player2;
	Player dealer;
	int deckIndex = 5;
	
	
	public BlackJackGame(GameApplication ga){
		myApp = ga;
		
		gameDeck = new Deck();
		gameDeck.shuffle();
		
		player1 = new Player(gameDeck.getCard(0), gameDeck.getCard(3), "player");
		player2 = new Player(gameDeck.getCard(1), gameDeck.getCard(4), "player");
		dealer  = new Player(gameDeck.getCard(2), gameDeck.getCard(4), "dealer");
	}
	
	public void startGame(){
		
		System.out.println("Welcome to my blackjack game.");
		System.out.println("Press 'H' to hit, and 'S' to stick.");
		
		System.out.println("Player 1 has " + player1.getHandValue());
		System.out.println("Player 2 has " + player2.getHandValue());
		
		player1.startTurn();
		
		System.out.println("PLayer 1 turn.");
		myApp.repaint();
	}
	
	public void paintGame( Graphics2D g2){
		player1.showCards(myApp, g2, 500, 400);
		player2.showCards(myApp, g2,100, 400);
		dealer.showCards(myApp, g2, 300, 100);
	}
	
	public void checkPlayer1Win(){
		if (player1.isBust())
			System.out.println("Player 1 busted and loses.");
		else{
			if (dealer.isBust())
				System.out.println("Player 1 beat the dealer and wins.");
			else if (player1.getHandValue() > dealer.getHandValue())
				System.out.println("Player 1 beat the dealer and wins.");
			else if (player1.getHandValue() == dealer.getHandValue())
				System.out.println("Player 1 and the Dealer push");
			else
				System.out.println("Player 1 one didn't beat the dealer and loses.");
		}
	}
	
	public void checkPlayer2Win(){
		if (player2.isBust())
			System.out.println("Player 2 busted and loses.");
		else{
			if (dealer.isBust())
				System.out.println("Player 2 beat the dealer and wins.");
			else if (player2.getHandValue() > dealer.getHandValue())
				System.out.println("Player 2 beat the dealer and wins.");
			else if (player2.getHandValue() == dealer.getHandValue())
				System.out.println("Player 2 and the Dealer push");
			else
				System.out.println("Player 2 one didn't beat the dealer and loses.");
		}
	}
	
	public void restart(){
		dealer.endTurn();
		deckIndex = 5;
		gameDeck.shuffle();
		
		player1.newHand(gameDeck.getCard(0), gameDeck.getCard(3));
		player2.newHand(gameDeck.getCard(1), gameDeck.getCard(4));
		dealer.newHand(gameDeck.getCard(2), gameDeck.getCard(5));
		
		player1.startTurn();
		myApp.repaint();
	}
	
	public void userInput(String command){
		
		if (player1.isActive()){
			
			if (command == "hit"){
				player1.addCard(gameDeck.getCard(deckIndex));
				System.out.println("Player 1 has " + player1.getHandValue());
				deckIndex++;
				if(player1.isBust()){
					player1.endTurn();
					System.out.println("Player 1 busts!");
					System.out.println("PLayer 2 turn.");
					player2.startTurn();
				}
				myApp.repaint();
			}
			else if (command == "stick"){
				player1.endTurn();
				System.out.println("Player 1 sticks with " + player1.getHandValue());
				System.out.println("Player 2 turn.");
				player2.startTurn();
			}
		}
		else if (player2.isActive()){
			
			if (command == "hit"){
				if(!player2.isBust()){
					player2.addCard(gameDeck.getCard(deckIndex));
					System.out.println("Player 2 has " + player2.getHandValue());
					deckIndex++;
					if(player2.isBust()){
						player2.endTurn();
						System.out.println("Payer 2 busts");
						System.out.println("Dealer turn.");
						System.out.println("Press 'D' to figure out what the dealer has.");
						dealer.startTurn();
					}
					myApp.repaint();
				}
			}
			else if (command == "stick"){
				player2.endTurn();
				System.out.println("Player 2 sticks with " + player2.getHandValue());
				System.out.println("Dealers turn.");
				System.out.println("Press 'D' to figure out what the dealer has.");
				dealer.startTurn();
				myApp.repaint();
			}
		}
		else if (command == "nextHand" && dealer.isActive())
			restart();
		else if (dealer.isActive()){
			if (command == "dealer"){
				if (dealer.isActive()){
					if(dealer.getHandValue() < 17){
						dealer.addCard(gameDeck.getCard(deckIndex));
						System.out.println("Dealer has " + dealer.getHandValue());
						deckIndex++;
						if(dealer.isBust()){
							System.out.println("Dealer Busts!");
							checkPlayer1Win();
							checkPlayer2Win();
							System.out.println("Press 'N' to play the next hand.");
						}
						myApp.repaint();
					}
					else{
						System.out.println("Dealer sticks with " + dealer.getHandValue());
						checkPlayer1Win();
						checkPlayer2Win();
						System.out.println("Press 'N' to play the next hand.");
					}
				}
			}
		}
		
	}
}