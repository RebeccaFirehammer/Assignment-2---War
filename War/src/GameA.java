import java.util.Stack;

public class GameA {
	public Hand player1;
	public Hand player2;
	
	public GameA(){
		Deck deck = new Deck();
		deck.shuffleDeck();
		deck.deal(2);
		String tempName1 = "Calvin";
		String tempName2 = "Hobbes";
		player1 = deck.getHand(1);
		player2 = deck.getHand(2);
		player1.setName(tempName1);
		player2.setName(tempName2);
		int turnCount = 0;
		while(turnCount < 200 && !player1.isEmpty() && !player2.isEmpty()){
			switch (round()){
				case 1:
					System.out.println(player1.getName() + " wins the round");
				break;
				case 2:
					System.out.println(player2.getName() + " wins the round");
				break;
				default:
					break;
			}
			turnCount++;
			System.out.println("Player1 has " + player1.size() + " cards, Player2 has " + player2.size() + " cards");
		}
		if(player1.isEmpty() || player1.size() < player2.size()){
			System.out.println(player2.getName() + " wins the game!");
		}
		else if(player2.isEmpty() || player1.size() > player2.size()){
			System.out.println(player1.getName() + " wins the game!");
		}
		else
			System.out.println("Tie game!");
	}
	
	public int round(){
		Card card1 = player1.pop();
		Card card2 = player2.pop();
		
		if(card1 == null && card2 == null){
			return 0;
		}
		else if(card1 == null){
			player2.push(card2);
			return 2;
		}
		else if(card2 == null){
			player1.push(card1);
			return 1;
		}
		System.out.println(player1.getName() + " plays " + card1.getValueName() + " of " + card1.getSuit());
		System.out.println(player2.getName() + " plays " + card2.getValueName() + " of " + card2.getSuit());
		if (card1.getValue() > card2.getValue()){
			player1.addToBottom(card1);
			player1.addToBottom(card2);
			return 1;
		}
		else if(card1.getValue() < card2.getValue()){
			player2.addToBottom(card2);
			player2.addToBottom(card1);
			return 2;
		}
		else{
			System.out.println("War!");
			Stack<Card> spoils = new Stack<Card>();
			spoils.push(card1);
			spoils.push(card2);
			for(int i = 0; i < 3; i++){
				if(player1.isEmpty() && player2.isEmpty()){
					return 0;
				}
				else if(player1.isEmpty()){
					while(!spoils.empty())
						player2.addToBottom(spoils.pop());						
					return 2;
				}
				else if(player2.isEmpty()){
					while(!spoils.empty())
						player1.addToBottom(spoils.pop());						
					return 1;
				}
				spoils.push(player1.pop());
				spoils.push(player2.pop());
				switch (round()){
					case 1:
						while(!spoils.empty())
							player1.addToBottom(spoils.pop());						
						return 1;
					case 2:
						while(!spoils.empty())
							player2.addToBottom(spoils.pop());
						return 2;
				}
			}
		}
		return 0;

	}
}
