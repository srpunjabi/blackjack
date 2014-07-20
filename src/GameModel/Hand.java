package GameModel;
import java.util.*;

import CardModel.Card;
import CardModel.Deck;

public class Hand 
{
	public Deck deck;
	private double bet;
	Dealer dealer;
	Player player;
	
	public Hand(double bet,Dealer dealer, Player player)
	{
		this.bet = bet;
		deck = new Deck();
		deck.newDeck();
		deck.shuffle();
		this.dealer = dealer;
		this.player = player;
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
	 * Creates a new BlackJack Hand, maintains player and dealer data, gets and prints results
	 * @return boolean telling us if the player won
	 */
	public boolean startHand()
	{
		//Deals Two Cards to both Player and Dealer
		dealPlayers(dealer, player);
		
		//Print player hands at start of the game
		dealer.printHand(true);
		player.printHand();
		
		//Get game results
		boolean result = getResults();
		
		//clearing player and dealer hands after each hand
		player.clearHand();
		dealer.clearHand();
		return result;
	}
	
	
	/************************ Private Helpers ****************************************/
	/**
	 * Checks various conditions to figure out the winner
	 * 1) Does player or dealer have BlackJack at the start->uses hasBlackJack() subroutine for this
	 * 2) Did player get busted
	 * 3) Did dealer get busted
	 * 4) if nobody got busted who has the higher hand
	 * @return true if player won and false if player lost
	 */
	public boolean getResults()
	{
		if(hasBlackJack())//if either player or both player and dealer have blackjack
		{
			return true;
		}
		if(playerBusted())//if player goes over 21
		{
			System.out.println("You went bust so you loose      Score:" + player.score());
			return false;
		}
		else if(dealerBusted())//if dealer goes over 21
		{
				System.out.println("Dealer Busted		Dealer Score: " + dealer.score());
				double newbalance = player.getBalance() + bet + bet;
				player.setBalance(newbalance);
				System.out.println("			You won your new balance: $" + player.getBalance());
				return true;
		}
		else
		{
			if(dealer.score() > player.score())//if dealer has a higher sore without going bust
			{
				System.out.println("Dealer win with the highscore of: " + dealer.score());
				return false;
			}
			else if(dealer.score() == player.score())//if dealer and player tied
			{
				System.out.println("Both you and Dealer have tied: " + dealer.score());
				double newbalance = player.getBalance() + bet;
				player.setBalance(newbalance);
				System.out.println("Your bet us refunded   new Balance: $" + player.getBalance());
				return true;
			}
			
			else if(player.score() == 21)//Check if Player reached blackJack
			{
				System.out.println("Congratulations you have blackjack      Score:" + player.score());
				double newbalance = player.getBalance() + (bet / 2) * 3 + bet;
				player.setBalance(newbalance);
				System.out.println("You won your new balance: " + player.getBalance());
				return true;	
			}
		}
		return false;
	}
	/**
	 * Checks if at the start of the game if dealer or player have BlackJack from two cards dealt.
	 * 1) if both have BlackJack
	 * 2) if Player has BlackJack
	 * 3) if Dealer has BlackJack but player doesn't
	 * @return true if in any case player has BlackJack and false otherwise
	 */
	private boolean hasBlackJack() {
		
		if(dealer.score() == 21 && player.score()==21)//Check if both dealer and player have BlackJack
		{
			
			double newbalance = player.getBalance() + bet;
			player.setBalance(newbalance);
			System.out.println("Both you and Dealer have a BlackJack your bet is refunded to you"
			+ " new balance: $" + player.getBalance());
			return true;
		}
		else if(player.score() == 21)//Check if Player has blackJack in the first two cards
		{
			System.out.println("Congratulations you have blackjack      Score:" + player.score());
			double newbalance = player.getBalance() + (bet / 2) * 3 + bet;
			player.setBalance(newbalance);
			System.out.println("You won your new balance: " + player.getBalance());
			return true;	
		}
		else if(dealer.score() == 21)//Check if Dealer has BlackJack in the first two cards
		{
			System.out.println("Dealer has BlackJack		you loose");
			return false;
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
		while(score < 17)
		{	
			Card card = deck.drawCard();
			dealer.hit(card);
			score += card.getRank().getRank();
		}
		dealer.printHand(false);
		if(score > 21)
			return true;
		return false;
	}
	
	/**
	 * Game Loop for player. Player can choose to Hit or Stand
	 * @return true if player got busted and false if player stands
	 */
	private boolean playerBusted() 
	{
		Scanner input = new Scanner(System.in);
		String action;
		boolean exFlag = false;
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
						break;
					}
				}
				if (action.equalsIgnoreCase("stand")) 
				{
					player.stand();
					exFlag = false;
					player.stand();
					break;
				} 
				else 
				{
					exFlag = true;
					InputMismatchException e = new InputMismatchException();
					throw e;
				}
			} 
			catch (InputMismatchException e) 
			{
				System.out.println("please enter a valid string");
			}
			
		} while (exFlag && stand == false);
		
		return bust;
	}
}
