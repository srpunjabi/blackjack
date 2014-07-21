package MainController;
import java.util.*;
/**
 * This class is the entry point for the game.  It is the main controller that interacts with GameControllerDelegate class to facilitate the game.
 * @author Sumit Punjabi
 *
 */
public class GameController 
{	
	private double balance;	//Player balance set to $100 
	
	/**
	 * Entry point for the game.  This method has a gameLoop that is used for input/output for player interaction.
	 * @param args
	 */
	public static void main(String [] args)
	{	
		double bet;
		double minimumBet = 1;
		GameController blackJack = new GameController();
		blackJack.balance = 100;
		Scanner userInput = new Scanner(System.in);
		GameControllerDelegate game = new GameControllerDelegate(blackJack.balance);
		System.out.println("Welcome to our BlackJack Table.  Normal wins pay 1:1 and BlackJack pays 2:3");
		//The game goes on until the player is out of funds
		while(game.player.getBalance() >= minimumBet)
		{
			//Starts a new Black Jack hand at each iteration and passes the bet downstream to GameControllerDelegate after validating it.
			try 
			{
				System.out.println("Please enter a valid bet amount minimum is $1.00"+
						"             Your Balance is $" + game.player.getBalance());
				bet = Double.parseDouble(userInput.nextLine());
				if(bet <= game.player.getBalance() && bet >= minimumBet )
				{
					game.newHand(bet);
				}
			} 
			catch (NumberFormatException e) 
			{
				System.out.println("You entered an incorrect input");
			}
		}
		System.out.println("Game over");
		userInput.close();
	}
}
