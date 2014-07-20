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
	
	public void hit(Card card) 
	{
		this.hand.add(card);
	}

	
	public void stand() 
	{
		// TODO Auto-generated method stub	
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void clearHand()
	{
		hand.clear();
	}
	
	public void printHand()
	{
		System.out.print("Your hand: ");

		for(Card card : this.hand)
		{
			System.out.print(card.printCard() +" ");
		}
		System.out.println("					currentScore:"+ this.score()+ "   current Balance: $" + this.getBalance());
	}
}