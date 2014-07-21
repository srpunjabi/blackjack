package GameModel;

import java.util.ArrayList;

import CardModel.Card;
/**
 * Dealer Class acts as a dealer at a BlackJack Table
 * @author Sumit Punjabi
 *
 */
public class Dealer implements IPlayer
{
	private ArrayList<Card> hand;//list holding cards for the current round
	
	public Dealer()
	{
		this.hand = new ArrayList<Card>();
	}
	
	/**
	 * Adds the passed in card to ArrayList<Card>hand
	 */
	public void hit(Card card) 
	{
		hand.add(card);
	}
	
	/**
	 * Adds passed in cards to ArrayList<Cards>hand for the current game round.
	 * @param cards list of card objects to be added to dealer's hand
	 */
	public void updateHand(ArrayList<Card> cards)
	{
		this.hand.addAll(cards);
	}
	
	/**
	 * Returns the list of cards in the current hand of dealer
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
	 * prints the dealer's current Hand for the round
	 */
	public void printHand()
	{	
		System.out.print("Dealer's Hand: ");
		
		for(Card card : hand)
		{
			System.out.print(card.printCard() + " ");
		}
		System.out.println("     Dealer's Score: " + this.score());
		
	}
	
	/**
	 * Print the first card of the dealer's hand
	 */
	public void printfirstHand()
	{	
		System.out.print("Dealer's Hand: ");
	    System.out.println(hand.get(0).printCard());
	}
	
	/**
	 * Clears the ArrayList<Card> hand after each round
	 */
	public void clearHand()
	{
		hand.clear();
	}
	
	
}
