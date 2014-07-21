package Views;
/**
 * This class is responsible for printing various outcomes to the console
 */
import GameModel.Dealer;
import GameModel.Player;

public class PrintView
{
	Player player;
	Dealer dealer;
	double bet;

	/**
	 * printView Constructor takes Player, Dealer and bet as input
	 * @param player Player object instance
	 * @param dealer Dealer object instance
	 * @param bet 	double bet 
	 */
	public PrintView(Player player,Dealer dealer,double bet)
	{
		this.player = player;
		this.dealer = dealer;
		this.bet = bet;
	}

	/**
	 * prints appropriate message when dealer has a BlackJack hand or reaches BlackJack
	 */
	public void printdealerHasBlackJack() 
	{
		System.out.println("Dealer has BlackJack you loose");
	}

	/**
	 * prints appropriate message when Dealer has a higher score
	 */
	public void printdealerWin()
	{
		System.out.println("Dealer won this hand with higher hand you lost");
	}

	/**
	 * prints appropriate message when dealer goes bust and updates player balance
	 */
	public void printdealerBust()
	{
		System.out.println("Dealer Busted		Dealer Score: " + dealer.score());
		double newbalance = player.getBalance() + bet + bet;
		player.setBalance(newbalance);
		System.out.println("You Won		newbalance: $" + Math.round(player.getBalance()));
	}

	/**
	 * prints appropriate message when game is tied and returns player bet amount
	 */
	public void printgameTied()
	{
		System.out.println("Both you and Dealer have tied: " + dealer.score());
		double newbalance = player.getBalance() + bet;
		player.setBalance(newbalance);
		System.out.println("Your bet is refunded		new Balance: $" + Math.round(player.getBalance()));
	}

	/**
	 * prints appropriate message when player has BlackJack 3:2 bet amount is added to player balance
	 */
	public void printPlayerBlackJack()
	{
		System.out.println("Congratulations you have blackjack      Score:" + player.score());
		double newbalance = player.getBalance() + (bet / 2) * 3 + bet;
		player.setBalance(newbalance);
		System.out.println("You won		new balance: " + player.getBalance());
	}

	/**
	 * prints appropriate message when Player has higher score and updates player's balance
	 */
	public void printPlayerWin()
	{
		double newbalance = player.getBalance() + bet + bet;
		player.setBalance(newbalance);
		System.out.println("You won your new balance: " + player.getBalance());
	}

	/**
	 * prints appropriate message when Dealer looses and updates player balance 1:1
	 */
	public void printdealerLost()
	{
		System.out.println("Dealer Lost		Dealer Score: " + dealer.score());
		double newbalance = player.getBalance() + bet + bet;
		player.setBalance(newbalance);
		System.out.println("You won with higher score: " + player.score() +"  new balance: $" + Math.round(player.getBalance()));
	}
}
