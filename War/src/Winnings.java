import java.util.Stack;

public class Winnings {
	private Stack<Card> stack = new Stack<Card>();
	
	public void push(Card card){
		if (card != null)
			stack.push(card);
	}
	
	public Card pop(){
		if(!stack.isEmpty())
			return stack.pop();
		else
			return null;
	}
	
	public boolean empty(){
		return stack.isEmpty();
	}
	
	public int size(){
		return stack.size();
	}
}