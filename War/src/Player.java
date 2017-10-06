
public class Player {
	
	private String playerName;
	private Hand playerHand;
	private int score;
	
	public Player(String playerName) {
		this.playerName = playerName;
		playerHand = new Hand();
		score = 0;
	}

	public String getPlayerName() {
		return playerName;
	}

	public Hand getPlayerHand() {
		return playerHand;
	}
	
	public void addPoints(int points) {
		score += points;
	}
	
	public int getScore() {
		return score;
	}
	
}