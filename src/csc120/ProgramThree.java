package csc120;
import java.text.NumberFormat;
import java.util.Scanner;
//import cardgames.*;
//**********************************************************************************
//Name: Ryan McGregor
//Class: CSC 120
//Professor: Graham
//Assignment: Program 3
//ProgramThree.java
//**********************************************************************************
public class ProgramThree {

	static Scanner scan = new Scanner(System.in);
	static String name;

	public static void createName(){
		System.out.print("Please enter your name: ");
		name = scan.next();
	}
	public String readName(){
		return name;
	}

	public static boolean isNumber(String str){
		try{
			@SuppressWarnings("unused")
			double d = Double.parseDouble(str);
		}
		catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}

	public static void main(String[] args){

		Deck myDeck = new Deck();
		myDeck.shuffle();
		//Card tempCard = new Card();
		//tempCard = myDeck.deal();
		//GUI myGui = new GUI(3);
		//myGui.showCard(tempCard);

		NumberFormat currencyFormater = 
				NumberFormat.getCurrencyInstance();

		BlackJack game = new BlackJack();
		String betAmountString = "";
		double betAmount = 0;
		double winningPercentage;
		String yesorNo = "y";

		double potAmount = 500;

		createName();

		while(yesorNo.equalsIgnoreCase("y") && potAmount != 0){
			System.out.println(" ");
			System.out.println("Your pot total is: " + currencyFormater.format(potAmount));
			System.out.println("How much would you like to bet?");

			betAmountString = scan.next();

			if(isNumber(betAmountString))
				betAmount = Double.parseDouble(betAmountString);


			while(betAmount > potAmount || betAmount <= 0 || !isNumber(betAmountString)){
				if(!isNumber(betAmountString)){
					System.out.println("That's not a valid amount,"
							+ " please enter a valid amount to bet: ");
					betAmountString = scan.next();
					if(isNumber(betAmountString))
						betAmount = Double.parseDouble(betAmountString);

				}
				if(betAmount > potAmount && isNumber(betAmountString)){
					System.out.println("You don't have that much to bet! Enter" +
							" a new amount: ");
					betAmountString = scan.next();
					if(isNumber(betAmountString))
						betAmount = Double.parseDouble(betAmountString);

				}
				else if(betAmount < 0 && isNumber(betAmountString)){
					System.out.println("You can't bet a negative amount! Enter" +
							" a new amount: ");
					betAmountString = scan.next();
					if(isNumber(betAmountString))
						betAmount = Double.parseDouble(betAmountString);
				}
				else if(betAmount == 0 && isNumber(betAmountString)){
					System.out.println("You have to bet something! Enter a new amount: ");
					betAmountString = scan.next();
					if(isNumber(betAmountString))
						betAmount = Double.parseDouble(betAmountString);
				}
			}
			game.playGame();

			if(game.gameWin() == 0)
				potAmount = potAmount - betAmount;

			if(game.gameWin() == 1)
				potAmount = potAmount + betAmount;

			if(game.gameWin() == 2)
				potAmount = potAmount + (betAmount * 1.5);

			if(potAmount == 0)
				System.out.println("You lose!");

			if(potAmount != 0){
				System.out.println(" ");
				System.out.println("Would you like to play again?");
				yesorNo = scan.next();
				while((yesorNo.equalsIgnoreCase("y") == false) && 
						(yesorNo.equalsIgnoreCase("n") == false)){
					System.out.println("That's not Y or N, I'll ask again;");
					System.out.println("Would you like to play again?");
					yesorNo = scan.next();
				}
			}
		}

		if((potAmount - 500) < 0){
			System.out.println("You ended up with " + currencyFormater.format(potAmount) + ".");
			System.out.println("You lost " + (currencyFormater.format(500 - potAmount)) + ".");
		}
		else if(potAmount - 500 > 0){
			System.out.println("You ended up with " + currencyFormater.format(potAmount) + "!");
			System.out.println("You won " + (currencyFormater.format(potAmount - 500)) + "!");
		}
		else{
			System.out.println("You ended up with " + currencyFormater.format(potAmount) + ".");
			System.out.println("You broke even.");
		}
		winningPercentage = 1000 * (((double)game.ties/2) + game.myWins)/
				(game.myWins + game.dealerWins + game.ties);


		if(winningPercentage == 1000)
			System.out.println("Your winning percentage is 1.000");

		else if(winningPercentage == 0)
			System.out.println("Your winning percentage is .000");
		else
			System.out.println("Your winning percentage is: ." + (int)winningPercentage);
		if(game.bestStreak == 1)
			System.out.println("Your best winning streak was " + 
					game.bestStreak + " game.");
		else
			System.out.println("Your best winning streak was " + 
					game.bestStreak + " games.");

		if(game.dealerBestStreak == 1)
			System.out.println("The dealers' best winning streak was " 
					+ game.dealerBestStreak + " game.");
		else
			System.out.println("The dealers' best winning streak was " 
					+ game.dealerBestStreak + " games.");
	}
}
	

