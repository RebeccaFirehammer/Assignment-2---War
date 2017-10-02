import java.util.Stack;

public class GameB {
	private Hand player1;
	private Hand player2;
	private Winnings player1wins = new Winnings();
	private Winnings player2wins = new Winnings();

	public GameB() {
		Deck deck = new Deck();
		deck.shuffleDeck();
		deck.deal(2);
		String tempName1 = "Abbott";
		String tempName2 = "Costello";
		player1 = deck.getHand(1);
		player2 = deck.getHand(2);
		player1.setName(tempName1);
		player2.setName(tempName2);

		while (!player1.isEmpty() && !player2.isEmpty()) {
			switch (round()) {
			case 1:
				System.out.println(player1.getName() + " wins the round");
				break;
			case 2:
				System.out.println(player2.getName() + " wins the round");
				break;
			default:
				break;
			}
			System.out.println("Score is " + player1.getName() + " " + player1wins.size() + ", " + player2.getName()
					+ " " + player2wins.size());
		}
		if (player1wins.size() < player2wins.size()) {
			System.out.println(player2.getName() + " wins the game!");
		} else if (player1wins.size() > player2wins.size()) {
			System.out.println(player1.getName() + " wins the game!");
		} else
			System.out.println("Tie game!");
	}

	public int round() {
		Card card1 = player1.pop();
		Card card2 = player2.pop();

		if (card1 == null && card2 == null) {
			return 0;
		} else if (card1 == null) {
			player2wins.push(card2);
			return 2;
		} else if (card2 == null) {
			player1wins.push(card1);
			return 1;
		}
		System.out.println(player1.getName() + " plays " + card1.getValueName() + " of " + card1.getSuit());
		System.out.println(player2.getName() + " plays " + card2.getValueName() + " of " + card2.getSuit());
		if (card1.getValue() > card2.getValue()) {
			player1wins.push(card1);
			player1wins.push(card2);
			return 1;
		} else if (card1.getValue() < card2.getValue()) {
			player2wins.push(card2);
			player2wins.push(card1);
			return 2;
		} else {
			System.out.println("War!");
			Stack<Card> spoils = new Stack<Card>();
			spoils.push(card1);
			spoils.push(card2);

			if (player1.isEmpty() && player2.isEmpty()) {
				return 0;
			} else if (player1.isEmpty()) {
				while (!spoils.empty())
					player2wins.push(spoils.pop());
				return 2;
			} else if (player2.isEmpty()) {
				while (!spoils.empty())
					player1wins.push(spoils.pop());
				return 1;
			}
			spoils.push(player1.pop());
			spoils.push(player2.pop());
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
