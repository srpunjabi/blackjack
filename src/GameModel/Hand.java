package GameModel;
import java.util.*;

import Views.PrintView;
import CardModel.Card;
import CardModel.Deck;
/**
 * This class contains various methods to create a new BlackJack hand, new Card Deck, print and update results
 * @author Sumit Punjabi
 */
public class Hand 
{
	public Deck deck;
	private double bet;
	Dealer dealer;
	Player player;
	PrintView view;
	
	/**
	 * Constructor for Hand
	 * @param bet double amount that player bet
	 * @param dealer dealer object
	 * @param player player object
	 */
	public Hand(double bet,Dealer dealer, Player player)
	{	
		this.bet = bet;
		deck = new Deck();
		deck.newDeck();
		deck.shuffle();
		this.dealer = dealer;
		this.player = player;
		this.view = new PrintView(player,dealer,this.bet);
	}

	/**
	 * Populates Array<Card> hand that both dealer and player has
	 * @param dealer instance of Dealer Class
	 * @param player instance of Player Class
	 */
	public void dealPlayers(Dealer dealer,Player player)
	{
		this.dealer.updateHand(deck.dealCards(2));
		this.player.updateHand(deck.dealCards(2));
	}

	/**
	 * Creates a new BlackJack Hand, maintains player and dealer data, updates and prints results
	 */
	public void startHand()
	{
		//Deals Two Cards to both Player and Dealer
		dealPlayers(dealer, player);
		
		//Print player hands at start of the game
		dealer.printfirstHand();//dealer only shows one card at the start
		player.printHand();
		
		//Prints the game results
		printResults();
		
		//clearing player and dealer hands after each hand
		player.clearHand();
		dealer.clearHand();
	}
	
	/************************ Private Helpers ****************************************/
	/**
	 * Checks various conditions to figure out the winner
	 * 1) Does player or dealer have BlackJack at the start->uses hasBlackJack() subroutine for this
	 * 2) Did player get busted
	 * 3) Did dealer get busted
	 * 4) if nobody got busted who has won the hand
	 */
	private void printResults()
	{	//Check if anyone has BlackJack at the start
		if(player.score() == 21 && dealer.score()==21)
			view.printgameTied();
		else if(player.score() == 21)
			view.printPlayerBlackJack();
		else if(dealer.score() == 21)
			view.printdealerHasBlackJack();
		else
		{
			if(playerBusted())
				playerResult();
			else if(dealerBusted())
				dealerResult();
			else
			{
				playerResult();//Updates player data and prints the results
				dealerResult();//Updates dealer data and prints the results
			}
		}
	}
	
	/**
	 * Evaluates various possibilities after dealer is done hitting and calls the appropriate printing method in printView class
	 */
	private void dealerResult()
	{
		int dealerScore = dealer.score();
		int playerScore = player.score();
		if(dealerScore > 21)//Dealer goes bust
		{
			view.printdealerBust();
		}
		else if(dealerScore<21 && dealerScore > playerScore)//Dealer Wins
		{
			view.printdealerWin();
		}
		else if(dealerScore == playerScore)//game tied
		{
			view.printgameTied();
		}
		else if(dealerScore == 21)//dealer has blackjack
		{
			view.printdealerHasBlackJack();
		}
	}
	
	/**
	 * Evaluates the game of the side of player.  Checks various condition to validate victory or loss.
	 * Checks if player went bust
	 * Checks if player reached 21
	 * Checks if player has higherScore than dealer or when Dealer goes bust
	 * @return boolean
	 */
	private boolean playerResult()
	{
		int playerScore = player.score();
		int dealerScore = dealer.score();
		if(playerScore > 21)//player busted
		{
			System.out.println("You went bust so you loose      Score:" + player.score());
		}
		else if(playerScore == 21 && (dealerScore<21 || dealerScore>21))//Player has blackJack
		{
			view.printPlayerBlackJack();
		}
		else if(playerScore < 21 && playerScore > dealerScore)//Player has higher score
		{	
			view.printdealerLost();
			view.printPlayerWin();
		}
		else if(playerScore<21 && dealerScore > 21)//Player is under 21 but dealer busted
		{
			view.printdealerBust();
			return true;
		}
		
		return false;

	}
	
	/**This function is a private helper for getResults().  
	 * Game Loop for dealer. Dealer must hit until he or she is over 17 and stand once over 17
	 * @return true if dealer goes over 21 and false otherwise
	 */
	private boolean dealerBusted() 
	{
		int score = dealer.score();
		while (score < 17) {
			Card card = deck.drawCard();
			dealer.hit(card);
			score += card.getRank().getRank();
		}
		dealer.printHand();
		if (score > 21)
			return true;
		else
			return false;
	}
	
	/**
	 * Game Loop for player. Player can choose to Hit or Stand
	 * @return true if player got busted and false if player stands
	 */
	private boolean playerBusted() 
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String action;
	
		boolean stand = false;
		boolean bust = false;
		do {
			try 
			{
				System.out.println("hit or stand");
				action = input.nextLine();
				if (action.equalsIgnoreCase("hit")) 
				{
					player.hit(deck.drawCard());
					player.printHand();
					if(player.score() > 21)
					{
						bust = true;
						break;
					}
					else if(player.score() == 21)
					{
						return false;
					}
				}
				else if (action.equalsIgnoreCase("stand")) 
				{
					stand = true;
					break;
				} 
				else 
				{
					InputMismatchException e = new InputMismatchException();
					throw e;
				}
			} 
			catch (InputMismatchException e) 
			{
				System.out.println("please enter a valid string");
			}
	
		} while (stand == false && bust==false);
		return bust;
	}
}
