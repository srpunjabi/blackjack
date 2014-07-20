import GameModel.Dealer;
import GameModel.Hand;
import GameModel.Player;


public class GameController 
{
	Dealer dealer;
	Player player;
	public GameController(double balance)
	{
		dealer = new Dealer();
		player = new Player();
		player.setBalance(balance);
	}
	
	public void newHand(double bet)
	{
		double newBalance = player.getBalance()-bet;
		player.setBalance(newBalance);
		Hand hand = new Hand(bet,dealer,player);
		boolean playerWon = hand.startHand();
	}
	
	
	
	
}
