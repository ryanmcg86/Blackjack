package csc120;
//**********************************************************************************
//Name: Ryan McGregor
//Class: CSC 120
//Professor: Graham
//Assignment: Program 3
//Card.java
//**********************************************************************************
public class Card {
	private int rank;
	private int suit;
	
	Card(){
		rank = (int)(Math.random()*13);
		suit = (int)(Math.random()*4);
	}
	public Card(int n){
		if(n >= 0 && n <= 51){
			rank = n % 13;
			suit = n / 13;
		}
	}
	public Card(int r, int s) {
		if((r >= 0 && r <= 12) && (s >= 0 && s <= 3)){
			rank = r;
			suit = s;	
		}
	}
	public String toString() {
		return getRankAsString() + getSuitAsString();
	}
	public void setRank(int r) {
		if(r >= 0 && r <= 12)
			rank = r;
	}
	public int getRank() {
		return rank;
	}
	public void setSuit(int s) {
		if(s >= 0 && s <= 3)
			suit = s;
	}
	public int getSuit() {
		return suit;
	}	
	public String getRankAsString()
	{
		String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		return ranks[rank];
	}	
	/**************************************************************************/
	public String getSuitAsString()
	{
		String[] suits = {"C","D","H","S"};
		return suits[suit];	
	}	
	public int getValue() {
		return rank + suit * 13;		
	}
	public boolean equals(Card c) {
		return ((rank == c.rank) && (suit == c.suit));
	}
	public int compareByRank(Card c) {
		return rank - c.rank;
	}
	public int compareBySuit(Card c) {
		return suit- c.suit;
	}
}
