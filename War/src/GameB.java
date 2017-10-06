import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GameB {
	private Player player1;
	private Player player2;
	private Winnings player1wins = new Winnings();
	private Winnings player2wins = new Winnings();

	public GameB() {
		Deck deck = new Deck();
		List<Player> players = new ArrayList<Player>();
		player1 =  new Player("Abbott");
		player2 = new Player("Costello");
		
		players.add(player1);
		players.add(player2);
		
		deck.shuffle();
		deck.deal(players);

		while (!player1.getPlayerHand().isEmpty() && !player2.getPlayerHand().isEmpty()) {
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
			System.out.println("Score is " + player1.getPlayerName() + " " + player1wins.size() + ", " + player2.getPlayerName()
					+ " " + player2wins.size());
		}
		if (player1wins.size() < player2wins.size()) {
			System.out.println(player2.getPlayerName() + " wins the game!");
		} else if (player1wins.size() > player2wins.size()) {
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
			player2wins.push(card2);
			return 2;
		} else if (card2 == null) {
			player1wins.push(card1);
			return 1;
		}
		System.out.println(player1.getPlayerName() + " plays " + card1.getRank() + " of " + card1.getSuit());
		System.out.println(player2.getPlayerName() + " plays " + card2.getRank() + " of " + card2.getSuit());
		if (card1.getRank().compareTo(card2.getRank()) > 0) {
			player1wins.push(card1);
			player1wins.push(card2);
			return 1;
		} else if (card1.getRank().compareTo(card2.getRank()) < 0) {
			player2wins.push(card2);
			player2wins.push(card1);
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
					player2wins.push(spoils.pop());
				return 2;
			} else if (player2.getPlayerHand().isEmpty()) {
				while (!spoils.empty())
					player1wins.push(spoils.pop());
				return 1;
			}
			spoils.push(player1.getPlayerHand().pop());
			spoils.push(player2.getPlayerHand().pop());
			switch (round()) {
			case 1:
				while (!spoils.empty())
					player1wins.push(spoils.pop());
				return 1;
			case 2:
				while (!spoils.empty())
					player2wins.push(spoils.pop());
				return 2;
			}
		}
		return 0;

	}

}
