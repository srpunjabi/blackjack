package GameModel;

import CardModel.Card;

public interface IPlayer 
{	
	public abstract void hit(Card card);
	public abstract void stand();
}
