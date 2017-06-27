package csc120;
//**********************************************************************************
//Name: Ryan McGregor
//Class: CSC 120
//Professor: Graham
//Assignment: Program 3
//BlackjackHand.java
//**********************************************************************************
public class BlackjackHand {
	
	private Card[] hand;			//-hand : Card[]			-Array of Cards
	
	private int count;				//-count : int				-Number of Cards in the Hand
	
	BlackjackHand(){				//+BlackjackHand()			-Create an array of 10 cards
		hand = new Card[10];
	}
	
	public int getCount(){			//+getCount():int			-Return number of Cards in 
		return count;				//							 the hand
	}
	
	public boolean hasRank(int r){	//+hasRank(int r) : boolean	-Return true if a specified
		int i;						//							 rank is in the hand
		for(i = 0; i < count; i++){
		if (hand[i].getRank() == r)
			return true;
		}
		return false;
	}
	
	public String toString(){		//+toString(): String		-Return the hand as a String
		String hand = new String();
		return hand.toString();
	}
	
	public Card getCard(int x){		//+getCard(int x) : Card	-Return the Card at position x
		return hand[x];
	}
	
	public void addCard(Card c){	//+addCard(Card c) : void	-Add a card to the hand
		hand[count] = c;			//							 (at the end)
		count++;
	}
	public int evaluate(){			//+evaluate() : int			-Return the value of the hand
		int i = 0;					//							 with the highest possible
		int j = 0;					//							 points under 22
		int aceCount = 0;
		int sum = 0;
		for(i = 0; i < count; i++){
			if(hand[i].getRank() >= 0 && hand[i].getRank() <= 8){
					j = hand[i].getRank() + 2;
					sum = sum + j;
				}
				else if(hand[i].getRank() >= 9 && hand[i].getRank() <= 11){
					j = 10;
					sum = sum + j;
				}
				else if(hand[i].getRank() > 11){
					j = 1;
					aceCount++;
					sum = sum + j;
						}
			
			}
		if((aceCount > 0) && ((sum + 10) <= 21)){
			sum = sum + 10;
			}
		return sum;
			}
	}
		
