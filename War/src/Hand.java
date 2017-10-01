import java.util.Stack;

public class Hand {
	private Stack<Card> stack = new Stack<Card>();
	private String name = null;
	
	public void setName(String newName){
		name = newName;
	}
	
	public String getName(){
		return name;
	}

	public void push(Card card){
		stack.push(card);
	}
	
	public Card pop(){
		if(!stack.isEmpty())
			return stack.pop();
		else
			return null;
	}
	
	public void addToBottom(Card card){
		Stack<Card> reversedStack = new Stack<Card>();
		while(!stack.empty()){
			reversedStack.add(stack.pop());
		}
		
		reversedStack.add(card);
		
		while(!reversedStack.empty()){
			stack.add(reversedStack.pop());
		}
	}
	
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	
	public int size(){
		return stack.size();
	}
}
