package GameModel;

import CardModel.Card;

public interface IPlayer 
{	
	/**
	 * Hit method to be implemented by Player and Dealer classes
	 * @param card
	 */
	public abstract void hit(Card card);
}
