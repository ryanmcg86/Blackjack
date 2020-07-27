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
	private String name;		//-name : String			-Player's name
	
	private BlackjackHand hand;	//-hand : BlackjackHand		-Player's Hand of Cards
	
	private int points;			//-points : int				-Player's current points in 
								//							 the game
	
	public Player(){
		name = "Dealer";			//+Player()				-Name the player ‘Dealer’
		hand = new BlackjackHand(); //						-Create a BlackJack hand
		points = 0;
	}
	
	
	public Player(String n){		//+Player(String n)
		name = n;					//						-Name the player with the 
									//						 parameter
		hand = new BlackjackHand();	//						-Create a BlackJack hand
		points = 0;
	}
	
	public void setName(String n){	//+setName(String n) : void	  -Change the player's 
		//				   name using the parameter
	
		
		n = name;
		name = playerName.readName();
	}
	public String getName(){		//+getName() : String	-Return the player's name
		return name;
	}
	
	public String toString(){		//+toString() : String			-Return player's info
		int i = 0;					//								 as a String
		String summaryA = (getName() + ": " + hand.getCount() +" cards: ");//(I.E. Name,
		String summaryB = "";		//								 hand and value
		String summaryC = (": " + getPoints() + " points.");//		 of hand)
		for(i = 0; i < hand.getCount(); i++){
			summaryB = summaryB + (getCard(i) + " ");
			}
		return summaryA + summaryB + summaryC;
	}
	
	public BlackjackHand getHand(){	//+getHand() : BlackjackHand	-Return the hand
		return hand;
	}
	
	public void addCard(Card c){	//+addCard(Card c) : void		-Add card to the hand
		hand.addCard(c);
		}
	public Card getCard(int x){		//+getCard(int x) : Card		-Return the Card at
		return hand.getCard(x);		//								 position x
	}
	
	public int getPoints(){			//+getPoints() : int			-Evaluate the player's
		points = hand.evaluate();	//								 hand
		return points;				//								-Return the value of
	}								//								 the hand
	
}
