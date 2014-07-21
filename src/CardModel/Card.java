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
		if((this.rank == Rank.King) || (this.rank == Rank.Queen) || (this.rank == Rank.Jack) || (this.rank == Rank.Ace))
		{
			cardString = this.rank.toString() + " " + this.suit.toString();
			return cardString;
		}
		cardString = this.rank.getRank() + " " + this.suit.toString();
		return cardString;
	}
	
	/**
	 * Checks if current card object and the argument card object are equal by comparing their rank and suit
	 * @param card a Card object
	 * @return boolean true if both cards are equal and false otherwise
	 */
	public boolean equals(Card card)
	{
		if((this.suit == card.suit) && (this.rank == card.rank))
			return true;
		return false;	
	}
	
	/**
	 * Return the blackJack value of the card so its rank for card 2 to 10 and 10 for face cards except Ace
	 * @return int returning numeric rank of each card.
	 */
	public int blackJackValue()
	{
		if((this.rank == Rank.King) || (this.rank == Rank.Queen) || (this.rank == Rank.Jack))
		{
			return 10;
		}
		else
			return this.rank.getRank();
	}
	
	/**
	 * Check if the current card is an Ace by comparing ranks of current card and Rank.Ace enum
	 * @return boolean true if the card is an Ace and false otherwise.
	 */
	public boolean isAce()
	{
		if(this.rank == Rank.Ace)
			return true;
		else
			return false;
	}
}
