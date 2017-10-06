
public class Player {
	
	private String playerName;
	private Hand playerHand;
	private int score;
	
	public Player(String playerName) {
		this.playerName = playerName;
		playerHand = new Hand();
		score = 0;
	}
	
	public void addCardToHand(Card card) {
		playerHand.push(card);
	}
	
	public void addPoints(int points) {
		score += points;
	}

	public String getPlayerName() {
		return playerName;
	}

	public Hand getPlayerHand() {
		return playerHand;
	}
	
	public int getScore() {
		return score;
	}
	
}