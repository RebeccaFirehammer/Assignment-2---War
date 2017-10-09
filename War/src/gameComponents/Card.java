package gameComponents;

public class Card {
	
	private CardRank rank;
	private CardSuit suit;
	
	public Card(CardRank rank, CardSuit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public CardRank getRank() {
		return rank;
	}
	
	public CardSuit getSuit(){
		return suit;
	}
	
	public String toString() {
		return rank + " of " + suit;
	}

}
