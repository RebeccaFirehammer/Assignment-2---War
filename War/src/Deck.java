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
		for(int i = 0; !cards.empty(); i++) {
			players.get(i%(players.size())).getPlayerHand().push(cards.pop());
		}
	}
	
	public void addCard(Card card) {
		cards.push(card);
	}
	
}