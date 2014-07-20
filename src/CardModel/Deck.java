
package CardModel;
import java.util.ArrayList;
import java.util.Random;

/**@author Sumit Punjabi
 */

public class Deck 
{
	private final ArrayList<Card> cardDeck = new ArrayList<Card>();
	public Deck(){}
	
	/**
	 * This method creates a new deck of cards.  Iterates over Suits and Ranks in a nested loop and populates the ArraList<Card> cardDeck
	 */
	public void newDeck()
	{
		for(Rank rank: Rank.values())
		{
			for(Suit suit: Suit.values())
			{
				this.cardDeck.add(new Card(rank,suit));
			}
		}
	}
	
	/**This function shuffles the Deck of cards.  It is based on the Fisher-Yates Shuffle also known as Knuth Shuffle. 
	 * Create a Random class instance and use it to generate a random int in the range of cardDeck size.
	 * Use the random int to get the Card at that location in the list and swap that with the card at current the loop index.
	 */
	public void shuffle()
	{
		Random rand = new Random();
		for(int i = 0; i < cardDeck.size();i++)
		{
			int randomPosition = rand.nextInt(cardDeck.size());
			Card temp = cardDeck.get(i);
			cardDeck.set(i, cardDeck.get(randomPosition));
			cardDeck.set(randomPosition, temp);
		}
	}
	
	
	/**This function deals cards to the players. Create an instance of Random class and generate a random int in the 
	 * range of cardDeck size. Remove the Card at that location and return it.
	 * @return A Card object removed from a random index in cardDeck
	 */
	public ArrayList<Card> dealCards(int totalCards)
	{
		Random rand = new Random();
		ArrayList<Card> hand = new ArrayList<Card>();
		for(int i = 0; i < totalCards;i++)
		{
			Card temp = cardDeck.remove(rand.nextInt(cardDeck.size()));
			hand.add(temp);
		}
		return hand;
	}
	
	/**
	 * This function draws a single card from the deck removes and returns it.
	 * @return a Card object drawn randomly
	 */
	public Card drawCard()
	{
		Random rand = new Random();
		Card temp = cardDeck.remove(rand.nextInt(cardDeck.size()));
		return temp;
	}

	
}
