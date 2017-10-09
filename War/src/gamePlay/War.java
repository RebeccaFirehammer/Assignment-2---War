package gamePlay;

import java.util.ArrayList;
import gameComponents.Deck;
import gameComponents.Player;

public abstract class War {
	protected Player player1;
	protected Player player2;
	protected Deck deck = new Deck();
	protected ArrayList<Player> players;
	
	public War(){

	}
	
	public void setUpGame(ArrayList<Player> players){
		deck.shuffle();
		deck.deal(players);
	}
	
	public abstract void playGame();
	public abstract int round();
}
