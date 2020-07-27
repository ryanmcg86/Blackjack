package csc120;
//**********************************************************************************
//Name: Ryan McGregor
//Class: CSC 120
//Professor: Graham
//Assignment: Program 3
//Blackjack.java
//**********************************************************************************
import java.util.Scanner;

public class BlackJack {
	ProgramThree title = new ProgramThree();
	//Player 1
	private Player dealer;
	//Player 2
	private Player n;
	private Deck deck;
	int i;
	int myWins           = 0;
	int dealerWins       = 0;
	int ties             = 0;
	int currentStreak    = 0;
	int bestStreak       = 0;
	int dealerStreak     = 0;
	int dealerBestStreak = 0;
	
	//Create a deck
	public BlackJack(){
		deck = new Deck();	
	}
	
	//Create a playGame function
	public void playGame(){
		//Create 2 Players
		dealer = new Player();
		n      = new Player();
		
		String name = null;
		n.setName(name);
		
		//Shuffle the deck
		deck.shuffle();
	
		String yesorNo = null;
	
		{
		//Deal 2 Cards to each Player	
		Card temp = deck.deal();
		dealer.addCard(temp);
			
		temp = deck.deal();
		n.addCard(temp);
			
		temp = deck.deal();
		dealer.addCard(temp);
			
		temp = deck.deal();
		n.addCard(temp);
		}
				
		//Display the player's info
		System.out.println(n.toString());		
	
		//Display the dealer's first card
		System.out.println("The Dealer's first card is a " + dealer.getCard(0));
	
		if(n.getPoints() == 21 && n.getHand().getCount() == 2){
			gameResults();
		}
		else if((dealer.getPoints() == 21) && (dealer.getHand().getCount() == 2)){
			gameResults();
		}
	
		else{
			//Permit the player to hit
			System.out.println("Would you like to hit? Y/N.");
			
			//until player stays or busts...
			Scanner scan = new Scanner(System.in);				 
			yesorNo = scan.next();
			
			while((yesorNo.equalsIgnoreCase("y") == false) && (yesorNo.equalsIgnoreCase("n") == false)){
				System.out.println("That's not Y or N, I'll ask again;");
				System.out.println("Would you like to hit?");
				yesorNo = scan.next();
			}
		
			//As long as the player wants to hit...
			while(yesorNo.equalsIgnoreCase("n") == false && yesorNo.equalsIgnoreCase("y")){
		
				//Deal a card
				Card temp = deck.deal();
				n.addCard(temp);
					//And check again if the player wants to hit
				if(n.getPoints() >= 21){
					System.out.println(n.toString());
					yesorNo = "no";
				}
				else{
					System.out.println(n.toString());
					System.out.println("Would you like to hit? Y/N.");
					yesorNo = scan.next();
					while((yesorNo.equalsIgnoreCase("y") == false) && (yesorNo.equalsIgnoreCase("n") == false)){
						System.out.println("That's not Y or N, I'll ask again;");
						System.out.println("Would you like to play again?");
						yesorNo = scan.next();
					}
					if(n.getPoints() > 21){
						System.out.println(n.toString());
				}
			}
		}
		if(n.getPoints() <= 21){
			//Dealer's turn (if necessary)
			for(i = 0; i < dealer.getHand().getCount(); i++){
				if(dealer.getHand().getCard(i).getRank() > 11){
					if((dealer.getHand().evaluate() <= 17)){ 
						//see rules on page 1
						Card temp = deck.deal();
						//Dealer must stand on 17 or more
						dealer.addCard(temp);
					}
				}								
				else if(dealer.getHand().evaluate() < 17){
					Card temp = deck.deal();
					dealer.addCard(temp);
				}
			} 
		}
		//Display game results
		gameResults();
	}
}
	
	public int gameWin(){
		int DPoints = dealer.getPoints();
		int PPoints = n.getPoints();
		
		//blackjack
		if(PPoints == 21 && n.getHand().getCount() == 2){
			return 2;
		}
		//dealer wins, no tie.
		else if(
				((DPoints > PPoints) && (DPoints <= 21)) ||
				((PPoints > 21) && (DPoints <= 21)) || 
				((DPoints == 21) && 
				(dealer.getHand().getCount() == 2) && 
				(n.getHand().getCount() != 2))
				){
			return 0;									
		}
		//player wins, no tie.
		else if(((DPoints < PPoints) && (PPoints <= 21)) || 
				(DPoints > 21 && PPoints <= 21)){
			return 1;									
		}
		//tie
		else if(((DPoints == PPoints) && (DPoints <= 21)) &&
				(n.getHand().getCount() != 2)){
			return 3;									
		}
		return 4;
	}
	
	//Compare the hands
	public void gameResults(){		
		System.out.println("Game over...");
		System.out.println(" ");
		String line = "======================================================="
		String spaces = "                     "
		int DPoints = dealer.getPoints();
		int PPoints = n.getPoints();
		//Display the winner
		if((DPoints > PPoints) && (DPoints <= 21)){
			System.out.println(spaces + "Game Results");
			System.out.println(line);
			System.out.println(spaces + "The Dealer won.");
			dealerWins++;
			currentStreak = 0;
			dealerStreak++;
		}
		else if((DPoints == PPoints) && (DPoints <= 21)){
			System.out.println(spaces + "Game Results");
			System.out.println(line);
			System.out.println(spaces + "You tied.");
			ties++;
		}
		else if(PPoints == 21 && n.getHand().getCount() == 2){
			System.out.println(spaces + "Game Results");
			System.out.println(line);
			System.out.println(spaces + "BLACKJACK!");
			System.out.println(spaces + "YOU WON!!!");
			myWins++;
			currentStreak++;
			dealerStreak = 0;
			}
		else if((DPoints < PPoints) && (PPoints <= 21)){
			System.out.println(spaces + "Game Results");
			System.out.println(line);
			System.out.println(spaces + "YOU WON!!!");
			myWins++;
			currentStreak++;
			dealerStreak = 0;
		}
		else if(DPoints > 21 && PPoints <= 21){
			System.out.println(spaces + "Game Results");
			System.out.println(line);
			System.out.println(spaces + "The Dealer busted.");
			System.out.println(spaces + "YOU WON!!!");
			myWins++;
			currentStreak++;
			dealerStreak = 0;
		}
		else if(PPoints > 21 && DPoints <= 21){
			System.out.println(spaces + "Game Results");
			System.out.println(line);
			System.out.println(spaces + "You busted.");
			System.out.println(spaces + "The Dealer won.");
			dealerWins++;
			currentStreak = 0;
			dealerStreak++;
		}
		else if(DPoints > 21 && PPoints > 21){
			System.out.println(spaces + "Game Results");
			System.out.println(line);
			System.out.println(spaces + "Both players busted... play again!");
		}
		else{
			System.out.println("Error");
			System.out.println(" ");
		}
		
		//establishes the value of the players best streak
		if(currentStreak > 0){
			if(bestStreak <= currentStreak){
				bestStreak = currentStreak;
			}
		}
		//establishes the value of the dealers best streak
		if(dealerStreak > 0){
			if(dealerBestStreak <= dealerStreak){
				dealerBestStreak = dealerStreak;
			}
		}
		
		System.out.println(" ");
		
		//Display Player info for all players
		System.out.println(dealer.toString());
		System.out.println(n.toString());
		
		System.out.println(" ");
		
		System.out.println(spaces + "Record: " + myWins + "-" + dealerWins + "-" + ties);
		
		System.out.println(" ");
		
		if(currentStreak > 0){
			if(currentStreak == 1){
				System.out.println("Current Winning Streak: " + currentStreak + " game in a row.");
			}
			else{ 
				System.out.println("Current Winning Streak: " + currentStreak + " games in a row.");
			}
		}
		else{
			if(dealerStreak == 1){
				System.out.println("Dealers' Current Winning Streak: " + dealerStreak + " game in a row.");
			}
			else{	
				System.out.println("Dealers' Current Winning Streak: " + dealerStreak + " games in a row.");
			}
		}
		System.out.println(line);
		
		deck.initialize();
		deck.shuffle();
	}
}
