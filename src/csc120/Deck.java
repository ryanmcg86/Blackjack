package csc120;
//**********************************************************************************
//Name: Ryan McGregor
//Class: CSC 120
//Professor: Graham
//Assignment: Program 3
//Deck.java
//**********************************************************************************


import javax.swing.ImageIcon;

public class Deck {
	private ImageIcon deckImage = new ImageIcon("./images/faceDown.jpg");
	private Card[] cards = new Card[52];
	private int lastCard;
	
	public Deck() {
		initialize();
	}
	/**************************************************************************/
	public void initialize(){
		for(int i = 0;i < 52; i++)	{
			cards[i] = (new Card(i));
		}		
	}
	/**************************************************************************/
	public String toString(){
		System.out.println("No. of cards: " + lastCard);
		String retVal = " ";
		for(int i = 0; i < 52;i++)
		{
			retVal = retVal + cards[i].toString() + ", ";
		}
		return retVal;
	}
	/**************************************************************************/
	public void shuffle() {
		int i, k;
		lastCard = 0;
		for(i = 51; i > 0; i--)
		{
			k = (int)(Math.random() * (i+1));
			Card temp;
			
			temp = (Card)cards[i];
			cards[i] = cards[k];
			cards[k] = temp;			
		}
	}	
	/**************************************************************************/	
	public int lastCardDealt() {
		return lastCard;
	}
	/**************************************************************************/
	public Card deal() {
		Card temp;
		if(lastCard < 52)
		{
			temp = cards[lastCard];
			lastCard++;
		}
		else 
			temp = null;
		return temp;
	}
	/**************************************************************************/
	public ImageIcon getImageIcon() {
		return deckImage;
	}
}

