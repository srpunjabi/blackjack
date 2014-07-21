package MainController;
import GameModel.Dealer;
import GameModel.Hand;
import GameModel.Player;


public class GameControllerDelegate 
{
	Dealer dealer;
	Player player;
	
	/**
	 * Constructor for GameControllerDelegate creates Player, Dealer and updates the balance
	 * @param balance
	 */
	public GameControllerDelegate(double balance)
	{
		dealer = new Dealer();
		player = new Player();
		player.setBalance(balance);
	}
	
	/**
	 * Creates a new hand for a BlackJack game
	 * Deducts the bet from player balance and calls the Hand's public method to start the game.
	 * @param bet double bet amount
	 */
	public void newHand(double bet)
	{
		double newBalance = player.getBalance()-bet;
		player.setBalance(newBalance);
		Hand hand = new Hand(bet,dealer,player);
		hand.startHand();
	}
	
	
	
	
}
