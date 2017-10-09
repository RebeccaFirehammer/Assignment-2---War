package gamePlay;
import java.util.Stack;

import gameComponents.Card;
import gameComponents.Player;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GameA extends War {
	
	private int turnCount = 0;

	public GameA() {
		
		player1 = new Player("Calvin");
		player2 = new Player("Hobbes");
		players = new ArrayList<Player>(Arrays.asList(player1, player2));
		
		setUpGame(players);
		playGame();

	}
	
	public void playGame(){
		while (turnCount < 200 && !player1.getPlayerHand().isEmpty() && !player2.getPlayerHand().isEmpty()) {
			switch (round()) {
			case 1:
				System.out.println(player1.getPlayerName() + " wins the round");
				break;
			case 2:
				System.out.println(player2.getPlayerName() + " wins the round");
				break;
			default:
				break;
			}
			turnCount++;
			System.out.println(player1.getPlayerName() + "  has " + player1.getPlayerHand().size() + " cards, " + player2.getPlayerName() + " has "
					+ player2.getPlayerHand().size() + " cards");
		}
		if (player1.getPlayerHand().isEmpty() || player1.getPlayerHand().size() < player2.getPlayerHand().size()) {
			System.out.println(player2.getPlayerName() + " wins the game!");
		} else if (player2.getPlayerHand().isEmpty() || player1.getPlayerHand().size() > player2.getPlayerHand().size()) {
			System.out.println(player1.getPlayerName() + " wins the game!");
		} else
			System.out.println("Tie game!");
	}

	public int round() {
		Card card1 = player1.getPlayerHand().pop();
		Card card2 = player2.getPlayerHand().pop();

		if (card1 == null && card2 == null) {
			return 0;
		} else if (card1 == null) {
			player2.getPlayerHand().push(card2);
			return 2;
		} else if (card2 == null) {
			player1.getPlayerHand().push(card1);
			return 1;
		}
		System.out.println(player1.getPlayerName() + " plays " + card1.getRank() + " of " + card1.getSuit());
		System.out.println(player2.getPlayerName() + " plays " + card2.getRank() + " of " + card2.getSuit());
		if (card1.getRank().compareTo(card2.getRank()) > 0) {
			player1.getPlayerHand().addToBottom(card1);
			player1.getPlayerHand().addToBottom(card2);
			return 1;
		} else if (card1.getRank().compareTo(card2.getRank()) < 0) {
			player2.getPlayerHand().addToBottom(card2);
			player2.getPlayerHand().addToBottom(card1);
			return 2;
		} else {
			System.out.println("War!");
			Stack<Card> spoils = new Stack<Card>();
			spoils.push(card1);
			spoils.push(card2);
			if (player1.getPlayerHand().isEmpty() && player2.getPlayerHand().isEmpty()) {
				return 0;
			} else if (player1.getPlayerHand().isEmpty()) {
				while (!spoils.empty())
					player2.getPlayerHand().addToBottom(spoils.pop());
				return 2;
			} else if (player2.getPlayerHand().isEmpty()) {
				while (!spoils.empty())
					player1.getPlayerHand().addToBottom(spoils.pop());
				return 1;
			}
			switch (round()) {
			case 1:
				while (!spoils.empty())
					player1.getPlayerHand().addToBottom(spoils.pop());
				return 1;
			case 2:
				while (!spoils.empty())
					player2.getPlayerHand().addToBottom(spoils.pop());
				return 2;
			}
		}
		return 0;

	}
}
