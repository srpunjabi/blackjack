package CardModel;

public enum Rank 
{
	Ace(1),
	Two(2),
	Three(3),
	Four(4),
	Five(5),
	Six(6),
	Seven(7),
	Eight(8),
	Nine(9),
	Ten(10),
	Jack(11),
	Queen(12),
	King(13);
	
	private int cardRank;
	
	/**
	 * Private constructor returns int values for the Rank 
	 * @param int numeric value of Rank
	 */
	private Rank(int cardRank)
	{
		this.cardRank = cardRank;
	}
	
	/**Rank getter instance method
	 * @return Returns the Rank of the current card instance
	 */
	public int getRank()
	{
		return this.cardRank;
	}
}
