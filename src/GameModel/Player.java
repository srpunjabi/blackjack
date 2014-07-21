package GameModel;

import java.util.ArrayList;

import CardModel.Card;

public class Player implements IPlayer 
{	
	private ArrayList<Card> hand;
	private double balance;
	
	
	public Player()
	{
		this.hand = new ArrayList<Card>();
	}
	
	/**
	 * Adds the passed in card to ArrayList<Card>hand
	 */
	public void hit(Card card) 
	{
		this.hand.add(card);
	}

	/**
	 * Adds passed in cards to ArrayList<Cards>hand for the current game round.
	 * @param cards list of card objects to be added to player's hand
	 */
	public void updateHand(ArrayList<Card> cards)
	{
		this.hand.addAll(cards);
	}
	
	/**
	 * Returns the list of cards in the current hand of player
	 * @return ArrayList<Card> 
	 */
	public ArrayList<Card>getHand()
	{
		return this.hand;
	}
	
	/**
	 * Returns the BlackJack score of the current ArrayList<Card> hand that dealer has
	 * Handles the special case of Ace and decides if Ace is 1 or 11
	 * @return int score
	 */
	public int score()
	{	
		int score = 0;
		int aceCounter = 0;
		int aceMaxValue = 11;//value of Ace is 11 if the hand is under 21
		int aceMinValue = 1;//value of Ace is 1 if the might go over with 11
		for(Card card: this.hand)
		{
			if(card.isAce())
			{
				aceCounter++;
			}
			else
				score += card.blackJackValue();
		}
		for(int i = 0; i < aceCounter;i++)
		{
			if(score < 21)
				score+= aceMaxValue;
			else
				score+= aceMinValue;
		}
		return score;
	}
	
	/**
	 * Returns the current Balance of the player
	 * @return double balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Setter used to update the balance
	 * @param balance player's current balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Clears the player's Array<Card>hand at the end of each hand
	 */
	public void clearHand()
	{
		hand.clear();
	}
	
	/**
	 * Prints the current hand of player from ArrayList<Card>hand
	 */
	public void printHand()
	{
		System.out.print("Your hand: ");

		for(Card card : this.hand)
		{
			System.out.print(card.printCard() +" ");
		}
		System.out.println("					currentScore:"+ this.score()+ "   current Balance: $" + Math.round(this.getBalance()));
	}
}