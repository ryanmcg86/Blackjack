package csc120;
//**********************************************************************************
//Name: Ryan McGregor
//Class: CSC 120
//Professor: Graham
//Assignment: Program 3
//BlackjackHand.java
//**********************************************************************************
public class BlackjackHand {
	//Array of Cards
	private Card[] hand;
	
	//Number of Cards in the Hand
	private int count;
	
	//Create an array of 10 cards
	BlackjackHand(){
		hand = new Card[10];
	}
	
	//Return number of Cards in the hand
	public int getCount(){
		return count;
	}
	
	//Return true if a specified rank is in the hand
	public boolean hasRank(int r){
		int i;
		for(i = 0; i < count; i++){
		if (hand[i].getRank() == r)
			return true;
		}
		return false;
	}
	
	//Return the hand as a String
	public String toString(){
		String hand = new String();
		return hand.toString();
	}
	
	//Return the Card at position x
	public Card getCard(int x){
		return hand[x];
	}
	
	public void addCard(Card c){	//Add a card to the hand (at the end)
		hand[count] = c;
		count++;
	}
	//Return the value of the hand with the highest possible points under 22
	public int evaluate(){
		int i = 0;
		int j = 0;
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
