import java.util.*;

public class GameView 
{	
	private double balance;	
	
	public static void main(String [] args)
	{	
		double bet;
		GameView blackJack = new GameView();
		blackJack.balance = 100;
		Scanner userInput = new Scanner(System.in);
		GameController game = new GameController(blackJack.balance);
		
		while(game.player.getBalance() >= 1)
		{
			try 
			{
				System.out.println("Please enter a valid bet amount minimum is $1.00"+
						"             Your Balance is $" + game.player.getBalance());
				bet = Double.parseDouble(userInput.nextLine());
				if(bet <= game.player.getBalance() && bet >= 1 )
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
