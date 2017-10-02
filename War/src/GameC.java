import java.util.Stack;

public class GameC {
	private Hand player1;
	private Hand player2;
	private Hand player3;
	private Winnings player1wins = new Winnings();
	private Winnings player2wins = new Winnings();
	private Winnings player3wins = new Winnings();

	public GameC() {
		Deck deck = new Deck();
		deck.shuffleDeck();
		deck.deal(3);
		String tempName1 = "Athos";
		String tempName2 = "Porthos";
		String tempName3 = "Aramis";
		player1 = deck.getHand(1);
		player2 = deck.getHand(2);
		player3 = deck.getHand(3);
		player1.setName(tempName1);
		player2.setName(tempName2);
		player3.setName(tempName3);

		while (!player1.isEmpty() || !player2.isEmpty() || !player3.isEmpty()) {
			switch (round()) {
			case 1:
				System.out.println(player1.getName() + " wins the round");
				break;
			case 2:
				System.out.println(player2.getName() + " wins the round");
				break;
			case 3:
				System.out.println(player3.getName() + " wins the round");
				break;		
			}						
			System.out.println("Score is " + player1.getName() + " " + player1wins.size() + ", " + player2.getName()
					+ " " + player2wins.size() + ", " + player3.getName() + " " + player3wins.size());
		}
		if (player1wins.size() < player2wins.size() && player3wins.size() < player2wins.size()) {
			System.out.println(player2.getName() + " wins the game!");
		} else if (player1wins.size() > player2wins.size() && player1wins.size() > player3wins.size()) {
			System.out.println(player1.getName() + " wins the game!");
		} else if (player3wins.size() > player1wins.size() && player3wins.size() > player2wins.size()) {
			System.out.println(player3.getName() + " wins the game!");
		} else
			System.out.println("Tie game!");
	}

	public int round() {
		Card card1 = player1.pop();
		Card card2 = player2.pop();
		Card card3 = player3.pop();

		if (card1 != null)
			System.out.println(player1.getName() + " plays " + card1.getValueName() + " of " + card1.getSuit());
		if (card2 != null)
			System.out.println(player2.getName() + " plays " + card2.getValueName() + " of " + card2.getSuit());
		if (card3 != null)
			System.out.println(player3.getName() + " plays " + card3.getValueName() + " of " + card3.getSuit());
	
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
			cardValues[0] = card1.getValue();
		if (card2 != null)
			cardValues[1] = card2.getValue();
		if (card3 != null)
			cardValues[2] = card3.getValue();
		
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
			if (player1.isEmpty() && player2.isEmpty() && player3.isEmpty()) {
				return 0;
			} else if (player1.isEmpty() && player3.isEmpty()) {
				while (!spoils.empty())
					player2wins.push(spoils.pop());
				return 2;
			} else if (player2.isEmpty() && player3.isEmpty()) {
				while (!spoils.empty())
					player1wins.push(spoils.pop());
				return 1;
			} else if (player1.isEmpty() && player2.isEmpty()) {
				while (!spoils.empty()) {
					player3wins.push(spoils.pop());
				}
				return 3;
			}
			spoils.push(player1.pop());
			spoils.push(player2.pop());
			spoils.push(player3.pop());
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
