import java.util.Collections;
import java.util.Stack;

public class Deck {
	private static Stack<Card> cardStack = new Stack<Card>();
	private Hand player1 = new Hand();
	private Hand player2 = new Hand();
	private Hand player3 = new Hand();
	
	public Deck(){
		
		Card card = new Card();
		for(int i = 2; i <= 14; i++){
			card.setValue(i);
			card.setSuit("SPADES");
			cardStack.push(card.copy());
			card.setValue(i);
			card.setSuit("DIAMONDS");
			cardStack.push(card.copy());
			card.setValue(i);
			card.setSuit("CLUBS");
			cardStack.push(card.copy());
			card.setValue(i);
			card.setSuit("HEARTS");
			cardStack.push(card.copy());

		}
	}
	
	public void shuffleDeck(){
		Collections.shuffle(cardStack);
	}

	public void deal(int players){
		
		while(!cardStack.empty()){
			player1.push(cardStack.pop());
			if (!cardStack.empty())
				player2.push(cardStack.pop());
			if (!cardStack.empty() && players == 3)
				player3.push(cardStack.pop());
		}
	}
	
	public Hand getHand(int player){
		switch(player){
		case 1:
			return player1;
		case 2:
			return player2;
		case 3:
			return player3;
		default:
			return null;
		}
		
	}
		
}
