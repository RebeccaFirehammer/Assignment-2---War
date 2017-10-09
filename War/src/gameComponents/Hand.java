package gameComponents;
import java.util.Stack;

public class Hand {
	private Stack<Card> cards;
	
	public Hand(){
		cards = new Stack<Card>();
	}

	public void push(Card card){
		cards.push(card);
	}
	
	public Card pop(){
		if(!cards.isEmpty())
			return cards.pop();
		else
			return null;
	}
	
	public void addToBottom(Card card){
		Stack<Card> reversedStack = new Stack<Card>();
		while(!cards.empty()){
			reversedStack.add(cards.pop());
		}
		
		reversedStack.add(card);
		
		while(!reversedStack.empty()){
			cards.add(reversedStack.pop());
		}
	}
	
	public boolean isEmpty(){
		return cards.empty();
	}
	
	public int size(){
		return cards.size();
	}
	
	public String toString() {
		return cards.toString();
	}
}