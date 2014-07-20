package CardModel;

public class Card 
{
	private final Rank rank;
	private final Suit suit;
	
	public Card(Rank rank, Suit suit) 
	{ 
		this.rank = rank; 
		this.suit = suit; 
	}
	
	/**
	 * Returns the rank of the card
	 * @return Rank Object
	 */
	public Rank getRank() 
	{
		return this.rank; 
	}

	/**
	 * Returns the suit of the card
	 * @return Suit Object
	 */
	public Suit getSuit() 
	{
		return this.suit;
	}
	
	/**
	 * Prints the current Card. Default rank values for normal cards and King, Jack, Queen for face cards +  Suit of the card
	 * @return String containing rank and suit
	 */
	public String printCard()
	{
		String cardString;
		if((this.rank == Rank.King) || (this.rank == Rank.Queen) || (this.rank == Rank.Jack))
		{
			cardString = this.rank.toString() + " " + this.suit.toString();
			return cardString;
		}
		cardString = this.rank.getRank() + " " + this.suit.toString();
		return cardString;
	}
	
	public boolean equals(Card card)
	{
		if((this.suit == card.suit) && (this.rank == card.rank))
			return true;
		return false;
			
	}
	
	public int blackJackValue()
	{
		if((this.rank == Rank.King) || (this.rank == Rank.Queen) || (this.rank == Rank.Jack))
		{
			return 10;
		}
		else
			return this.rank.getRank();
	}
	
	public boolean isAce()
	{
		if(this.rank == Rank.Ace)
			return true;
		else
			return false;
	}
	
}
