blackjack
=========

This is a text based BlackJack game created in java.
Design:
I have tried to follow MVC design pattern wherever possible.

This project contains four packages.
CardModel, GameModel, MainController and Views.

Package CardModel - Contains classes to support building a card deck.
Class Suit:  Enum Class contains fours types of Suits.
  
Class Rank:  Enum Class contains Ranks for 13 cards.
  
Class Card:  Uses Suit and Rank to support a Card object.
  
  



Package GameModel - Contains classes necessary to support gameplay.

Class IPlayer: Interface implemented by Player and Dealer

Class Dealer: Implements IPlayer to support Dealer associated actions

Class Player: Implements IPlayer to support Player associated actions

Class Hand:  Creates a new BlackJack hand with a new deck and supports the player and dealer gameplay.

  



Package MainControllers - Contains classes that control and delegate game components

GameController: Entry point for the game contains main class and a game Loop to support user interactions

GameControllerDelegate: Uses the information passed by GameController and delgates actions to other classes
  



Package Views:  Print appropriate responses to the console

Class printView: prints appropriate messages based on user interactions and game results 


