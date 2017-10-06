import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {
	private static Stack<Card> cards = new Stack<Card>();
	
	public Deck(){
		for(CardRank rank : CardRank.values()) {
			for(CardSuit suit : CardSuit.values()) {
				cards.push(new Card(rank, suit));
			}
		}
	}
	
	public void shuffle(){
		Collections.shuffle(cards);
	}

	public void deal(List<Player> players){
		Player currentPlayer;
		Card topCard;
		int totalPlayers = players.size();
		
		for(int i = 0; !cards.empty(); i++) {
			currentPlayer = players.get(i % totalPlayers);
			topCard = cards.pop();
			currentPlayer.addCardToHand(topCard);
		}
	}
	
	public void addCard(Card card) {
		cards.push(card);
	}
	
}