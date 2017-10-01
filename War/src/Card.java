
public class Card{
	private int value;
	private String suit;
	
	
	void setValue(int number){
		value = number;
	}
	
	void setSuit(String newSuit){
		suit = newSuit;
	}
	
	int getValue(){
		return value;
	}
	
	String getValueName(){
		switch(value){
			case 2:
				return "TWO";
			case 3:
				return "THREE";
			case 4:
				return "FOUR";
			case 5:
				return "Five";
			case 6:
				return "SIX";
			case 7:
				return "SEVEN";
			case 8:
				return "EIGHT";
			case 9:
				return "NINE";
			case 10:
				return "TEN";
			case 11:
				return "JACK";
			case 12:
				return "QUEEN";
			case 13:
				return "KING";
			case 14:
				return "ACE";
			default: return null;
		}
	}
	
	String getSuit(){
		return suit;
	}

	Card copy(){
		Card card = new Card();
		card.setValue(value);
		card.setSuit(suit);
		return card;		
	}
	

}
