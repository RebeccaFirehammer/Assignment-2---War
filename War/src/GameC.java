import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GameC {
	private Player player1;
	private Player player2;
	private Player player3;
	private Winnings player1wins = new Winnings();
	private Winnings player2wins = new Winnings();
	private Winnings player3wins = new Winnings();

	public GameC() {
		Deck deck = new Deck();
		List<Player> players = new ArrayList<Player>();
		player1 =  new Player("Athos");
		player2 = new Player("Porthos");
		player3 = new Player("Aramis");
		
		players.add(player1);
		players.add(player2);
		players.add(player3);
		
		deck.shuffle();
		deck.deal(players);

		while (!player1.getPlayerHand().isEmpty() || !player2.getPlayerHand().isEmpty() || !player3.getPlayerHand().isEmpty()) {
			switch (round()) {
			case 1:
				System.out.println(player1.getPlayerName() + " wins the round");
				break;
			case 2:
				System.out.println(player2.getPlayerName() + " wins the round");
				break;
			case 3:
				System.out.println(player3.getPlayerName() + " wins the round");
				break;		
			}						
			System.out.println("Score is " + player1.getPlayerName() + " " + player1wins.size() + ", " + player2.getPlayerName()
					+ " " + player2wins.size() + ", " + player3.getPlayerName() + " " + player3wins.size());
		}
		if (player1wins.size() < player2wins.size() && player3wins.size() < player2wins.size()) {
			System.out.println(player2.getPlayerName() + " wins the game!");
		} else if (player1wins.size() > player2wins.size() && player1wins.size() > player3wins.size()) {
			System.out.println(player1.getPlayerName() + " wins the game!");
		} else if (player3wins.size() > player1wins.size() && player3wins.size() > player2wins.size()) {
			System.out.println(player3.getPlayerName() + " wins the game!");
		} else
			System.out.println("Tie game!");
	}

	public int round() {
		Card card1 = player1.getPlayerHand().pop();
		Card card2 = player2.getPlayerHand().pop();
		Card card3 = player3.getPlayerHand().pop();

		if (card1 != null)
			System.out.println(player1.getPlayerName() + " plays " + card1.getRank() + " of " + card1.getSuit());
		if (card2 != null)
			System.out.println(player2.getPlayerName() + " plays " + card2.getRank() + " of " + card2.getSuit());
		if (card3 != null)
			System.out.println(player3.getPlayerName() + " plays " + card3.getRank() + " of " + card3.getSuit());
	
		if (card1 == null && card2 == null && card3 == null) {
			return 0;
		} else if (card1 == null && card3 == null) {
			player2wins.push(card2);
			return 2;
		} else if (card2 == null && card3 == null) {
			player1wins.push(card1);
			return 1;
		} else if (card1 == null && card2 == null) {
			player3wins.push(card3);
			return 3;
		}
	
		int[] cardValues = {-1, -1, -1};
		if (card1 != null)
			cardValues[0] = card1.getRank().ordinal();
		if (card2 != null)
			cardValues[1] = card2.getRank().ordinal();
		if (card3 != null)
			cardValues[2] = card3.getRank().ordinal();
		
		if (cardValues[0] > cardValues[1] && cardValues[0] > cardValues[2]) {
			player1wins.push(card1);
			player1wins.push(card2);
			player1wins.push(card3);
			return 1;
		} else if (cardValues[1] > cardValues[0] && cardValues[1] > cardValues[2]) {
			player2wins.push(card2);
			player2wins.push(card1);
			player2wins.push(card3);
			return 2;
		} else if (cardValues[2] > cardValues[1] && cardValues[2] > cardValues[0]) {
			player3wins.push(card2);
			player3wins.push(card1);
			player3wins.push(card3);
			return 3;
		} else {
			System.out.println("War!");
			Winnings spoils = new Winnings();
			spoils.push(card1);
			spoils.push(card2);
			spoils.push(card3);
			if (player1.getPlayerHand().isEmpty() && player2.getPlayerHand().isEmpty() && player3.getPlayerHand().isEmpty()) {
				return 0;
			} else if (player1.getPlayerHand().isEmpty() && player3.getPlayerHand().isEmpty()) {
				while (!spoils.empty())
					player2wins.push(spoils.pop());
				return 2;
			} else if (player2.getPlayerHand().isEmpty() && player3.getPlayerHand().isEmpty()) {
				while (!spoils.empty())
					player1wins.push(spoils.pop());
				return 1;
			} else if (player1.getPlayerHand().isEmpty() && player2.getPlayerHand().isEmpty()) {
				while (!spoils.empty()) {
					player3wins.push(spoils.pop());
				}
				return 3;
			}
			spoils.push(player1.getPlayerHand().pop());
			spoils.push(player2.getPlayerHand().pop());
			spoils.push(player3.getPlayerHand().pop());
			switch (round()) {
			case 1:
				while (!spoils.empty())
					player1wins.push(spoils.pop());
				return 1;
			case 2:
				while (!spoils.empty())
					player2wins.push(spoils.pop());
				return 2;
			case 3:
				while (!spoils.empty())
					player3wins.push(spoils.pop());
				return 3;
			}
		}
		return 0;
	}
}
