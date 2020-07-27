package csc120;
//**********************************************************************************
//Name: Ryan McGregor
//Class: CSC 120
//Professor: Graham
//Assignment: Program 3
//Player.java
//**********************************************************************************

public class Player {
	ProgramThree playerName = new ProgramThree();
	//Player's name
	private String name;
	//Player's Hand of Cards
	private BlackjackHand hand;
	//Player's current points in the game
	private int points;
	
	public Player(){
		//Name the player ‘Dealer’
		name = "Dealer";
		//Create a BlackJack hand
		hand = new BlackjackHand();
		points = 0;
	}
	
	
	public Player(String n){
		//Name the player with the given input
		name = n;
		//Create a BlackJack hand
		hand = new BlackjackHand();
		points = 0;
	}
	
	//Change the player's name using the parameter
	public void setName(String n){
		n = name;
		name = playerName.readName();
	}
	
	//Return the player's name
	public String getName(){
		return name;
	}
	
	//Return player's info as a String (I.E. Name, hand and value of hand)
	public String toString(){
		int i = 0;
		String summaryA = (getName() + ": " + hand.getCount() +" cards: ");
		String summaryB = "";
		String summaryC = (": " + getPoints() + " points.");
		for(i = 0; i < hand.getCount(); i++){
			summaryB = summaryB + (getCard(i) + " ");
			}
		return summaryA + summaryB + summaryC;
	}
	
	//Return the hand
	public BlackjackHand getHand(){
		return hand;
	}
	
	//Add card to the hand
	public void addCard(Card c){
		hand.addCard(c);
		}
	//Return the Card at position x
	public Card getCard(int x){
		return hand.getCard(x);
	}
	
	
	public int getPoints(){
		//Evaluate the player's hand
		points = hand.evaluate();
		//Return the value of the hand
		return points;
	}								 
}
