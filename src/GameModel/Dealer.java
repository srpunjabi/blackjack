package GameModel;

import java.util.ArrayList;

import CardModel.Card;

public class Dealer implements IPlayer 
{
	private ArrayList<Card> hand;
	public Dealer()
	{
		this.hand = new ArrayList<Card>();
	}
	public void hit(Card card) 
	{
		hand.add(card);
	}
	

	public void stand() 
	{
		
	}
	
	public void updateHand(ArrayList<Card> cards)
	{
		this.hand.addAll(cards);
	}
	
	public ArrayList<Card>getHand()
	{
		return this.hand;
	}
	
	public int score()
	{	
		int score = 0;
		for(Card card: this.hand)
		{
			if(card.isAce() && (score + 11 < 21))
			{
				score += 11;
			}
			else
				score += card.blackJackValue();
		}
		return score;
	}
	
	
	public void printHand(boolean firsttime)
	{	
		System.out.print("Dealer's Hand: ");
		if(firsttime)
		{
			System.out.println(hand.get(0).printCard());
		}
		else
		{
			for(Card card : hand)
			{
				System.out.print(card.printCard() + " ");
			}
			System.out.println();
		}
	}
	public void clearHand()
	{
		hand.clear();
	}
	
	
}
