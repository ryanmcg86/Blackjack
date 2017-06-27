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
	
	private Player dealer;				//-player1 : Player		Player 1
	
	private Player n;					//-player2 : Player		Player 2
	
	private Deck deck;					//-deck : Deck			Deck of Cards
	
	int i;
	
	int myWins = 0;
	
	int dealerWins = 0;
	
	int ties = 0;
	
	int currentStreak = 0;
	
	int bestStreak = 0;
	
	int dealerStreak = 0;
	
	int dealerBestStreak = 0;
	
	
	public BlackJack(){					//+BlackJack()			Create a deck
	deck = new Deck();	
	}
	
	public void playGame(){				//+playGame():void		-Create 2 Players
	
		dealer = new Player();
		
		n = new Player();
		String name = null;
		n.setName(name);
		
		deck.shuffle();					//						-Shuffle the deck
	
	
		String yesorNo = null;
	
		{
		Card temp = deck.deal();		//			-Deal 2 Cards to each Player
		dealer.addCard(temp);
			
		temp = deck.deal();
		n.addCard(temp);
			
		temp = deck.deal();
		dealer.addCard(temp);
			
		temp = deck.deal();
		n.addCard(temp);
		}
			
		
	
	System.out.println(n.toString());	//			-Display the player's info
	
	System.out.println("The Dealer's first card is a "//-Display the dealer's first
			+ dealer.getCard(0));	//					 card
	
	if(n.getPoints() == 21 && n.getHand().getCount() == 2){
		gameResults();
		}
	else if((dealer.getPoints() == 21) && (dealer.getHand().getCount() == 2)){
		gameResults();
	}
	
	else{
	System.out.println("Would you like to hit? Y/N.");//-Permit the player to hit
		Scanner scan = new Scanner(System.in);		//	until player stands or busts		 
		yesorNo = scan.next();
		while((yesorNo.equalsIgnoreCase("y") == false) && 
				(yesorNo.equalsIgnoreCase("n") == false)){
			System.out.println("That's not Y or N, I'll ask again;");
			System.out.println("Would you like to hit?");
			yesorNo = scan.next();
		}
		
		
		while(yesorNo.equalsIgnoreCase("n") == false
				&& yesorNo.equalsIgnoreCase("y")){
	
		Card temp = deck.deal();
		n.addCard(temp);
			if(n.getPoints() >= 21){
				System.out.println(n.toString());
				yesorNo = "no";
				}
		else{
			System.out.println(n.toString());
			System.out.println("Would you like to hit? Y/N.");
			yesorNo = scan.next();
			while((yesorNo.equalsIgnoreCase("y") == false) && 
					(yesorNo.equalsIgnoreCase("n") == false)){
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
	for(i = 0; i < dealer.getHand().getCount(); i++){//-Dealer's turn (if necessary)
		if(dealer.getHand().getCard(i).getRank() > 11){
			if((dealer.getHand().evaluate() <= 17)){ 
	Card temp = deck.deal();//						 	see rules on page 1
	dealer.addCard(temp);//							-Dealer must stand on 17 or more
		}
	}								//				-Dealer must hit on soft 17
	else if(dealer.getHand().evaluate() < 17){
	Card temp = deck.deal();
	dealer.addCard(temp);
	}
	} 
	}
	gameResults();					//				-Display game results
	}
	}
	public int gameWin(){
		int DPoints = dealer.getPoints();
		int PPoints = n.getPoints();
		if(PPoints == 21 && n.getHand().getCount() == 2){//blackjack
			return 2;
		}
		else if(
				((DPoints > PPoints) && (DPoints <= 21)) ||
				((PPoints > 21) && (DPoints <= 21)) || 
				((DPoints == 21) && 
				(dealer.getHand().getCount() == 2) && 
				(n.getHand().getCount() != 2))
				){
			return 0;									//dealer wins, no tie.
		}
		else if(((DPoints < PPoints) && (PPoints <= 21)) || 
				(DPoints > 21 && PPoints <= 21)){
			return 1;									//player wins, no tie.
		}
		else if(((DPoints == PPoints) && (DPoints <= 21)) &&
				(n.getHand().getCount() != 2)){
			return 3;									//tie
		}
		return 4;
		}
	public void gameResults(){		//+gameResults():void		-Compare the hands
		System.out.println("Game over...");
		System.out.println(" ");
		int DPoints = dealer.getPoints();
		int PPoints = n.getPoints();
		if((DPoints > PPoints) 
				&& (DPoints <= 21)){
			System.out.println("                     Game Results");
			System.out.println("====================================" +
					"===================");
									// 							-Display the winner
			System.out.println("                     The Dealer won.");
			dealerWins++;
			currentStreak = 0;
			dealerStreak++;
		}
		else if((DPoints == PPoints) && (DPoints <= 21)){
			System.out.println("                     Game Results");
			System.out.println("=====================================" +
					"==================");
			System.out.println("                     You tied.");
			ties++;
		}
		else if(PPoints == 21 && n.getHand().getCount() == 2){
			System.out.println("                     Game Results");
			System.out.println("======================================" +
					"=================");
			System.out.println("                     BLACKJACK!");
			System.out.println("                     YOU WON!!!");
			myWins++;
			currentStreak++;
			dealerStreak = 0;
			}
		else if((DPoints < PPoints) 
					&& (PPoints <= 21)){
				System.out.println("                     Game Results");
				System.out.println("===================================" +
						"====================");
				System.out.println("                     YOU WON!!!");
				myWins++;
				currentStreak++;
				dealerStreak = 0;
			}
			else if(DPoints > 21 && PPoints <= 21){
				System.out.println("                     Game Results");
				System.out.println("===================================" +
						"====================");
				System.out.println("                     The Dealer busted.");
				System.out.println("                     YOU WON!!!");
				myWins++;
				currentStreak++;
				dealerStreak = 0;
		}
			else if(PPoints > 21 && DPoints <= 21){
				System.out.println("                     Game Results");
				System.out.println("====================================" +
						"===================");
				System.out.println("                     You busted.");
				System.out.println("                     The Dealer won.");
				dealerWins++;
				currentStreak = 0;
				dealerStreak++;
			}
			else if(DPoints > 21 && PPoints > 21){
				System.out.println("                     Game Results");
				System.out.println("=====================================" +
						"==================");
				System.out.println("                     Both players busted... " +
						"play again!");
				}
			else{
				System.out.println("Error");
				System.out.println(" ");
			}
		if(currentStreak > 0){//					-establishes the value
			if(bestStreak <= currentStreak){//		 of the players best streak
				bestStreak = currentStreak;
			}
		}
		if(dealerStreak > 0){//						-establishes the value
			if(dealerBestStreak <= dealerStreak){//	 of the dealers best streak
				dealerBestStreak = dealerStreak;
			}
		}
		
		System.out.println(" ");
		
		System.out.println(dealer.toString());//			-Display Player info
		System.out.println(n.toString());//					 for all players
		
		System.out.println(" ");
		
		System.out.println("                     Record: " + myWins 
				+ "-" + dealerWins + "-" + ties);
		
		System.out.println(" ");
		
		if(currentStreak > 0){
		if(currentStreak == 1){
			System.out.println("Current Winning Streak: " + currentStreak 
					+ " game in a row.");
		}
		else{ 
			System.out.println("Current Winning Streak: " + currentStreak 
					+ " games in a row.");
		}
		}
		else{
		if(dealerStreak == 1){
			System.out.println("Dealers' Current Winning Streak: " + dealerStreak 
					+ " game in a row.");
		}
		else{	
		System.out.println("Dealers' Current Winning Streak: " + dealerStreak 
				+ " games in a row.");
		}
		}
		System.out.println("===========================================" +
				"============");
		
		deck.initialize();
		deck.shuffle();
		}
}



